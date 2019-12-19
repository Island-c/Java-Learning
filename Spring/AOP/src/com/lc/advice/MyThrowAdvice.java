package com.lc.advice;

public class MyThrowAdvice{
	public void myexception(Exception e ) {
		 System.out.println("执行异常通知，异常信息"+e.getMessage());
	}
}
