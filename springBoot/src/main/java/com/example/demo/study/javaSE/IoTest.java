package com.example.demo.study.javaSE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

public class IoTest {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/Users/admin/Desktop/supTables.txt");
		FileInputStream fis = null;
		if(f.exists()) {
			fis = new FileInputStream(f);
			
		}
		
		BufferedInputStream bis = null;
		bis = new BufferedInputStream(fis);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		byte []b = new byte[1024];
//		FileOutputStream fos = new FileOutputStream(f);
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = bis.read(b);
		FileOutputStream fos = new FileOutputStream(new File("C:/Users/admin/Desktop/myIo.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(b, 0, len);
		bos.flush();
		System.out.println(new String(b, 0, len));
		bos.close();
		bis.close();
	}
}
