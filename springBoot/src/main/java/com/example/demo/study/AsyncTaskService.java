package com.example.demo.study;


import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

@Configuration
public class AsyncTaskService {
	private int price = 50;
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Async
	public void excuteAsyncTask1(int i) {
//		try {
////			int n = (int)(Math.random() * 100D);
////			System.out.println(n);
//			System.out.println(i);
////			threadLocal.remove();
////			threadLocal.set(i);
////			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(">>" + threadLocal.get());
		if(threadLocal.get() == null) {
			threadLocal.set((int) (Math.random() * 100D));
		}
		price += threadLocal.get();
//		System.out.println("任务1：" + price + "threadName:" +Thread.currentThread().getName());
//		Date d = new Date();
//		System.out.println("耗时：" + d.getTime());
//		Thread.sleep(1000);
		System.out.println(threadLocal.get() + "任务1：" + price + "threadName:" +Thread.currentThread().getName());
//		threadLocal.remove();
		
	}
	@Async
	public void excuteAsyncTask2(int i) {
		threadLocal.set(i);
		Date d = new Date();
		price += threadLocal.get();
		System.out.println("任务2：" + price + "threadName:" +Thread.currentThread().getName());
		System.out.println("耗时：" + d.getTime());
	}
}
