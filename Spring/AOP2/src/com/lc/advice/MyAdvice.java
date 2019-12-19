package com.lc.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component 
@Aspect   //标志这个类是一个切面  
public class MyAdvice {
	@Before("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")
	public void mybefore(String name, int id) {
		System.out.println("前置:");
	}
//	
	 @After("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")   
	public void myafter(String name, int id) {
		System.out.println("后置：after");
		
	}
	 @AfterReturning("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")
	public void myaftering(String name,int id) {
		System.out.println("后置：after-returning");
	}
	
	 @AfterThrowing("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")
	public void mythrow(String name,int id) {
		System.out.println("异常");
	}
	
	 @Around("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")
	public Object myarround(ProceedingJoinPoint p,String name, int id) throws Throwable {
		System.out.println("环绕前置");
		Object result = p.proceed();
		System.out.println("环绕后置");
		return result;
	}
}
