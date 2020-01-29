package com.example.demo.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SpringStudy {
	private String name;
	public SpringStudy() {
		// TODO Auto-generated constructor stub
	}
	public SpringStudy(String name) {
		System.out.println(">>>>>>>>>>>>>>>.");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getMessage(String message) {
		System.out.println(message);
	}
}
