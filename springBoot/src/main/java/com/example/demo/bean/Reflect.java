package com.example.demo.bean;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan
public class Reflect {
	@Autowired
	private SpringStudy springStudy;
	public Reflect() {
		springStudy.getMessage(">>>");
	}
	public void getMessage() {
		
	}
	public static void main(String []args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
			Point p = new Point("1","2");
			Field fy = p.getClass().getField("y");
			fy.get(p);
			System.out.println(fy.get(p));
			Field fx = p.getClass().getDeclaredField("x");
			fx.setAccessible(true);
			System.out.println(fx.get(p));
	} 
}
