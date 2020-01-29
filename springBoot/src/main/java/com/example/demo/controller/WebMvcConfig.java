package com.example.demo.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	
	
	@Override  
    public void addCorsMappings(CorsRegistry registry) {  
        
        registry.addMapping("/**")  
                .allowedOrigins("*")    //允许所有前端站点调用
                .allowCredentials(true)  
                .allowedMethods("GET", "POST", "DELETE", "PUT")  
                .maxAge(1728000);  
    }  
	
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
}
