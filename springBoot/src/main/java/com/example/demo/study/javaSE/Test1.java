package com.example.demo.study.javaSE;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
//		System.out.println(SubClass.value);
		SuperClass [] s = new SuperClass[2];
		int a = 60;
		int b = 13;
		System.out.println(a|b);
		Integer i = 0;
		Integer.valueOf(a);
		int c = Integer.max(a, b);
		System.out.println(c);
		int [] arr = new int[]{2,3,15,4,7,6};
//		Arrays.sort(arr);
		
		System.out.println(Arrays.binarySearch(arr, 15));
		
	}
}
