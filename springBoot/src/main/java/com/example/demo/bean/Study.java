package com.example.demo.bean;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Study implements Runnable{
	int value= 10;
	private volatile boolean books;
	void changeValue() {
		this.value = 1;
	}
	
	public static void main(String [] arg) {
		OutputStream os;
		OutputStreamWriter osw = null;
		InputStream is;
		InputStreamReader isr = null;
		
		try {
			File f = new File("E:/study/firstMessage.txt");
			if(!f.exists()) {
				f.createNewFile();
			}
			os = new FileOutputStream(f);
			Byte [] b = {1,2,12,33,4};
			osw = new OutputStreamWriter(os,"UTF-8");
			for(int i=0;i<b.length;i++) {
				osw.write('a');
			}
			osw.flush();
			is = new FileInputStream("E:/study/firstMessage.txt");
			int size = is.available();
			System.out.println(size);
			isr = new InputStreamReader(is,"UTF-8");

			StringBuilder sb = new StringBuilder();
//			for(int i=0;i<2;i++) {
				while(isr.ready()) {
					sb.append((char)isr.read());
				}
//			}
				System.out.println(sb.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void run() {
		books = true;
		while(true) {
			// TODO Auto-generated method stub
			System.out.println(books);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void stop() {
		books = false;
		System.out.println(">>>>>");
	}

}
