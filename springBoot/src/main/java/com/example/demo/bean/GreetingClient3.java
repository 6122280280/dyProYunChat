package com.example.demo.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class GreetingClient3 extends Thread{
	Socket socket;
	BufferedWriter writer = null;
	public GreetingClient3() {
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
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			sc = new Scanner(System.in);
			String message = null;
			int index = 0;
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
		GreetingClient3 c3 = new GreetingClient3();
		Thread t = new Thread(c3);
		t.start();
		new Thread(c3.new getServerMessage()).start();
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
					writer.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
