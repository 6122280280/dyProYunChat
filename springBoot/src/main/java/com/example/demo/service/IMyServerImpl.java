package com.example.demo.service;

import javax.jws.WebService;

import com.example.demo.bean.IMyServer;

@WebService(endpointInterface="com.example.demo.bean.IMyServer")
public class IMyServerImpl implements IMyServer{

	@Override
	public int add(int a, int b) {
		System.out.println("a+b=" + (a + b));
		return a + b;
	}

	@Override
	public int minus(int a, int b) {
		System.out.println("a-b=" + (a - b));
		return a - b;
	}

}
