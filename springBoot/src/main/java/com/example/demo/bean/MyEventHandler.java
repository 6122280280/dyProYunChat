package com.example.demo.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyEventHandler implements ApplicationListener<MyApplicationEvent>{

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println(event.toString());
	}

}
