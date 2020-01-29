package com.example.demo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.example.demo.bean.Menu;
import com.example.demo.bean.Role;
import com.example.demo.service.MenuService;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

	@Autowired
	MenuService menuService;
	AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		//获取请求地址
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if("/login_p".equals(requestUrl)) {
			return null;
		}
		List<Menu> allMenu = menuService.getAllMenu();
		for(Menu menu: allMenu) {
			if(antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
				List<Role> roles = menu.getRoles();
				String[] values = new String[roles.size()];
				for(int i = 0;i < roles.size();i++) {
					values[i] = roles.get(i).getName();
				}
				return SecurityConfig.createList(values);
			}
		}
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
