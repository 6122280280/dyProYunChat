package com.example.demo.bean;

import org.junit.Test;

@MyAnnotation(color="red")
public class AnnotationTest {
	@Test
	public void test() {
		if(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation ma = AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println(ma.color());
		}
	}
}
