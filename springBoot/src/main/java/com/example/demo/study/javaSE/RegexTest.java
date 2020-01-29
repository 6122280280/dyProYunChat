package com.example.demo.study.javaSE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		String pattern = "(\\D*)";
		String content = "aasdsa ";
		
		Pattern matcher = Pattern.compile(pattern);
		Matcher m = matcher.matcher(content);
		System.out.println(m.find());
		System.out.println(m.group(1));
		System.out.println(m.matches());
		System.out.println(m.lookingAt());
	}
}
