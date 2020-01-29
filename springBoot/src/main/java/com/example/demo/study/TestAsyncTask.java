package com.example.demo.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestAsyncTask {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecuteConfig.class);
		AsyncTaskService task = context.getBean(AsyncTaskService.class);
		AsyncTaskService task1 = context.getBean(AsyncTaskService.class);
		System.out.println(task == task1);
		for(int i=0;i < 1;i++) {
//			System.out.println(task.excuteAsyncTask1(4));
//			System.out.println(task.excuteAsyncTask1(2));
//			System.out.println(task.excuteAsyncTask1(3));
//			System.out.println(task.excuteAsyncTask1(5));
//			System.out.println(task.excuteAsyncTask1(6));
			task.excuteAsyncTask1(4);
			task.excuteAsyncTask1(2);
//			System.out.println(k);
			
			task.excuteAsyncTask1(3);
//			task.excuteAsyncTask1(5);
//			task.excuteAsyncTask1(6);
		}
		Thread.sleep(1000);
//		System.out.println(k);
		context.close();
	}
}
