package com.example.demo.bean;

import javax.jws.WebService;

@WebService
public interface IMyServer {

	public int add(int a, int b);
	public int minus(int a, int b);
}
