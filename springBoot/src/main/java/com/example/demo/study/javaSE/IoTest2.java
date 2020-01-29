package com.example.demo.study.javaSE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.SortedSet;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

public class IoTest2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("C:/Users/admin/Desktop/微信图片_20190628093330.jpg");
		FileOutputStream fos = new FileOutputStream("C:/Users/admin/Desktop/dd.jpg");
		FileInputStream fis = null;
		if(file.exists()) {
			fis = new FileInputStream(file);
		}
//		FileImageInputStream fiis = new FileImageInputStream(file);
//		fiis.read();
//		FileImageOutputStream fios = new FileImageOutputStream(new File("C:/Users/admin/Desktop/aa.jpg"));
		byte []b = new byte[1024];
//		fios.write(b, 0, fiis.read());
//		fios.flush();
//		fios.close();
//		fiis.close();
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/admin/Desktop/aa.jpg"));
		int len = 0;
		while((len = bis.read(b)) != -1) {
			bos.write(b, 0, len);
			bos.flush();
		}
		bos.close();
		bis.close();
	}
}
