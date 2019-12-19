package com.lc.advice;

import java.rmi.RemoteException;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice{

	public void afterThrowing(Exception ex) throws Throwable{
		
		System.out.println("异常");
		
	}
}
