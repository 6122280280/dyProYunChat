package com.example.demo.bean;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyApplicationEvent(Object source) {
		super(source);
		System.out.println("自定义事件");
	}
	public String toString() {
		return "自定义事件";
	}
}
