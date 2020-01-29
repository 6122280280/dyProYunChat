package com.example.demo.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GreetingServer{
	private Map<String, BufferedWriter> socketMap;
	private Map<String, String> nameIpMap;
	public GreetingServer() {
		socketMap = new HashMap<>();
		nameIpMap = new HashMap<>();
	}
	public static void main(String[] args) {
		ServerSocket server = null;
		GreetingServer greetServer = new GreetingServer();
		try {
			server = new ServerSocket(8088);
			System.out.println("服务端已启动！");
			while(true) {
				Socket socket = server.accept();
				System.out.println("地址：" + socket.getRemoteSocketAddress() + "成功连接！");
				new Thread(greetServer.new Task(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class Task implements Runnable{
		private Socket socket;
		private String name;
		public Task(Socket socket) {
			this.socket = socket;
		}
		public String getName() throws IOException {
			String strName = null;
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write("请输入昵称！\n");
				writer.flush();
				while((strName = br.readLine()) != null) {
					if("".equals(strName.trim()) || socketMap.containsKey(strName)) {
						writer.write("该昵称为空或已存在，请重新输入！\n");
						writer.flush();
					}else {
						writer.write("昵称:"+strName+"  注册成功！ 当前在线人数"+(socketMap.size()+1)+"\n");
						writer.flush();
						return strName;
					}
				}
			} catch (IOException e) {
				System.out.println(socket.getRemoteSocketAddress()+"连接中断！");
				throw e;
			}
			return strName;
		}
		@Override
		public void run() {
			handleSocket();
		}
		void sendToAll(Map<String, BufferedWriter> writersMap, String message) throws IOException {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Set<String> keys = writersMap.keySet();
			String fromName = nameIpMap.get(socket.getRemoteSocketAddress().toString());
			for(String key:keys) {
				if(!"".equals(fromName) && !fromName.equals(key)) {
					writer = socketMap.get(key);
					System.out.println("群组（"+fromName+"）：" + message);
					writer.write(fromName+":"+message + "\n");
					writer.flush();
				}
			}
		}
		private void handleSocket() {
			InputStreamReader isr = null;
			BufferedReader br = null;
			BufferedWriter writer = null;
			try {
				name = getName();
				nameIpMap.put(socket.getRemoteSocketAddress().toString(), name);
				isr = new InputStreamReader(socket.getInputStream(),"UTF-8");
				br = new BufferedReader(isr);
				String message = null;
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				socketMap.put(name, writer);
				sendToAll(socketMap, "上线了！   当前在线人数" + socketMap.size());
				System.out.println("当前在线人数：" + socketMap.size());
				while((message = br.readLine()) != null) {
					String regex = "^@(.*)@(.*)";
					Pattern r = Pattern.compile(regex);
					Matcher matcher = r.matcher(message);
					String toName = "";
					String currMessage = "";
					if(matcher.find()) {
						System.out.println(matcher.group(1));
						System.out.println(matcher.group(2));
						toName = matcher.group(1);
						currMessage = matcher.group(2);
					}
					if(message.equals("exit")) {
						socketMap.remove(name);
						System.out.println(name + "已退出");
						writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						writer.write("已退出\n");
						writer.flush();
						sendToAll(socketMap, "已下线！ 当前在线人数" + socketMap.size());
					}else if(!"".equals(toName)){
						System.out.println(name + ":" + message);
						writer = socketMap.get(toName);
						writer.write(nameIpMap.get(socket.getRemoteSocketAddress().toString()) + ":" + currMessage + "(私聊)\n");
						writer.flush();
					}else {
						System.out.println(name + ":" + message);
						sendToAll(socketMap, message);
					}
				}
			} catch (IOException e) {
				socketMap.remove(name);
				try {
					sendToAll(socketMap, "当前在线人数"+socketMap.size());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(name + "已下线!");
			}finally {
				try {
					if(br != null) {
						br.close();
					}
					if(writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


