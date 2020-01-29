package com.example.demo.study.javaSE;

import java.util.Arrays;

public class GenericsTest {
	public <T> void printArray(T [] t){
			System.out.println(Arrays.toString(t));
	}
	public static void main(String[] args) {
		GenericsTest genericsTest = new GenericsTest();
		Integer [] a = {1,2,3};
		genericsTest.printArray(a);
	}
}
