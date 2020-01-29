package com.example.demo.bean;

import javax.jws.WebService;

import org.springframework.context.annotation.Configuration;
@WebService
@Configuration
public class Point {
	private String x;
	public String y;
	public Point() {
		// TODO Auto-generated constructor stub
		System.out.println(">>>>>>>");
	}
	
	public Point(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public void add(int m, int n) {
		System.out.println("m+n="+(m+n));
	}
	
}
