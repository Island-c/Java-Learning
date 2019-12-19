package com.lc.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("切点方法对象"+arg0+", 方法名："+arg0.getName());
		if(arg1!=null && arg1.length>0) {
			//有参数
			System.out.println("参数"+arg1[0]);
		}else {
			System.out.println("无参");
		}
		System.out.println("对象"+arg2);
		System.out.println("执行前置通知");
	}
}
