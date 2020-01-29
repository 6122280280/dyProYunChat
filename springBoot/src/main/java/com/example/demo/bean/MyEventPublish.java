package com.example.demo.bean;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyEventPublish implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;
	public void publish() {
		MyApplicationEvent ma = new MyApplicationEvent(this);
		applicationEventPublisher.publishEvent(ma);
	}

	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.applicationEventPublisher = publisher;
	}

}
