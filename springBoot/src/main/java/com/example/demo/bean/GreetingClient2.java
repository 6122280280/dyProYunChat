package com.example.demo.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class GreetingClient2 extends Thread{
	Socket socket;
	BufferedWriter writer = null;
	public GreetingClient2() {
		try {
			socket = new Socket("localhost", 8088);
			System.out.println("地址：" + socket.getRemoteSocketAddress() + "连接成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		super.run();
		Scanner sc = null;
		int index = 0;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			sc = new Scanner(System.in);
			String message = null;
			do{
				message = sc.nextLine();
				if(!"".equals(message)) {
					writer.write(message+"\n");
					writer.flush();
					index += 1;
				}else {
					System.out.println("输入不能为空，请重新输入！");
				}
			}while(index == 1 || !message.equals("exit"));
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		GreetingClient2 c2 = new GreetingClient2();
		Thread t = new Thread(c2);
		t.start();
		new Thread(c2.new getServerMessage()).start();
		
	}
	class getServerMessage implements Runnable{
		@Override
		public void run() {
			String serverMessage = null;
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
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
