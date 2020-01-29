package com.example.demo.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;

@Configuration
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent>{

	@Override
	public void onApplicationEvent(ContextStartedEvent arg0) {
		System.out.println("监听上下文启动事件");
	}

}
