package com.lc.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Pointcut("execution(* com.lc.test.Demo.demo1(String,int)) and args(name,id)")
	public void demo1(String name,int id) {
		//int i= 5/0;
		System.out.println("demo1");
	}
	
//	
//	public void demo2() {
//		System.out.println("demo2");
//	}
//	public void demo3() {
//		System.out.println("demo3");
//	}
//	public String demo4(String name) {
//		System.out.println("demo5");
//		return "demo5的返回值";
//	}

}
