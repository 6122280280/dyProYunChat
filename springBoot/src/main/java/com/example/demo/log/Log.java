package com.example.demo.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
@Configuration
@Aspect
public class Log {
	
	@Pointcut("execution(* com.example.demo.bean.Point.getX(..))")
	private void selectAll() {}
	
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("执行方法前");
	}
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("执行方法后，不考虑其结果");
	}
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturning(Object retVal) {
		System.out.println(retVal);
	}
//	@Around("selectAll()")
//	public void around(ProceedingJoinPoint pjp) throws Throwable {
//		
//		System.out.println("方法执行前执行");
//		Object ob = pjp.proceed();
//		System.out.println("方法执行后");
//	}
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("异常是：" + ex.toString());
	}
}
