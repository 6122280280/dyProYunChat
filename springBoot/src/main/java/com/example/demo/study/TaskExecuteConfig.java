package com.example.demo.study;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com.example.demo.study")
@EnableAsync
public class TaskExecuteConfig implements AsyncConfigurer{
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threads = new ThreadPoolTaskExecutor();
		threads.setCorePoolSize(3);
		threads.setMaxPoolSize(5);
		threads.setQueueCapacity(2);
		threads.initialize();
		return threads;
	}
}
