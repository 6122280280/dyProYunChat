package com.example.demo.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.config.AuthenticationAccessDeniedHandler;
import com.example.demo.config.UrlAccessDecisionManager;
import com.example.demo.config.UrlFilterInvocationSecurityMetadataSource;
import com.example.demo.service.HrService;
import com.example.demo.utils.HrUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	HrService hrservice;
	
	@Autowired
	UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
	
	@Autowired
	UrlAccessDecisionManager urlAccessDecisionManager;
	
	@Autowired
	AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
	@Bean
	public PasswordEncoder passwordEncoder() {
	    // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(hrservice).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers("/static/**");
//	}
//	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/modifyPassword","/register","/index.html","/login.html", "/static/**","/login_p");
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.authorizeRequests()
			.antMatchers("/modifyPassword","/register", "/login","/index.html","/login.html", "/static/**","/login_p").permitAll()
			.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
				
				@Override
				public <O extends FilterSecurityInterceptor> O postProcess(O o) {
					//注入自己创建的urlFilterInvocationSecurityMetadataSource
					o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
					o.setAccessDecisionManager(urlAccessDecisionManager);
					return o;
				}
				
			}).and().formLogin()
			  .loginPage("/login_p").loginProcessingUrl("/login")
			  .usernameParameter("username").passwordParameter("password").permitAll()
			  .failureHandler(new AuthenticationFailureHandler() {
				
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
						throws IOException, ServletException {
					response.setContentType("application/json;charset=utf-8");
					PrintWriter out = response.getWriter();
					StringBuffer sb = new StringBuffer();
					sb.append("{\"status\": \"error\",\"msg\":\"");
					if(exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
						sb.append("用户名或密码输入错误，登陆失败！");
					}else {
						sb.append("登陆失败！");
					}
					sb.append("\"}");
					out.write(sb.toString());
					out.flush();
					out.close();
				}
			}).successHandler(new AuthenticationSuccessHandler() {
				
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
						throws IOException, ServletException {
					HttpSession session = request.getSession();
					String username = request.getParameter("username");
					session.setAttribute("loginName", username);
//					request.getSession().setAttribute("name", request.getUserPrincipal().getName());
					response.setContentType("application/json,charset=utf-8");
					PrintWriter out = response.getWriter();
					
					ObjectMapper objectMapper = new ObjectMapper();
	                String sb = "{\"status\":\"success\",\"msg\":" + objectMapper.writeValueAsString(HrUtils.getCurrentHr()) + "}";
					out.write(sb);
					out.flush();
					out.close();
				}
			}).and().logout()
			  .permitAll().and().csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
	}
}
