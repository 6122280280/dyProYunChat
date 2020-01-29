package com.example.demo.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GreetingClient extends Thread{
	Socket client;
	BufferedWriter writer = null;
	public GreetingClient() {
		try {
			client = new Socket("localhost", 8088);
			System.out.println("地址：" + client.getRemoteSocketAddress() + "连接成功！");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		super.run();
		OutputStreamWriter osw = null;
		OutputStream outToServer = null;
		try {
			Scanner sc = new Scanner(System.in);
			String message = null;
			outToServer = client.getOutputStream();
			osw = new OutputStreamWriter(outToServer);
			writer = new BufferedWriter(osw);
			int index = 0;
			do {
				message = sc.nextLine();
				if(!"".equals(message)) {
					writer.write(message+"\n");
					writer.flush();
					index += 1;
				}else {
					System.out.println("输入不能为空，请重新输入！");
				}
			} while (index == 1 || !message.equals("exit"));
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		GreetingClient g = new GreetingClient();
		Thread t =  new Thread(g);
		t.start();
		new Thread(g.new getServerMessage()).start();
	}
	class getServerMessage implements Runnable{
		@Override
		public void run() {
			String serverMessage = null;
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
				while((serverMessage = br.readLine()) != null) {
					System.out.println(serverMessage);
					if(serverMessage.equals("已退出")) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

