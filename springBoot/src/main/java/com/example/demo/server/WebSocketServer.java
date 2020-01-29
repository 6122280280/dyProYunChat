package com.example.demo.server;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myws")
public class WebSocketServer {
	private String name;
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		session.getBasicRemote().sendText(message);
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("客户端连接成功");
	}
	public void onClose(Session session) throws IOException {
		session.getBasicRemote().sendText("连接关闭");
		System.out.println("连接关闭");
	}
}
