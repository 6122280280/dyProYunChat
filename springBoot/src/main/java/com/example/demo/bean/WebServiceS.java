package com.example.demo.bean;

import javax.xml.ws.Endpoint;

import com.example.demo.service.IMyServerImpl;

public class WebServiceS {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9999/point", new IMyServerImpl());
	}
}
