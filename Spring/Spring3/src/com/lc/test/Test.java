package com.lc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Teacher tea1 = ac.getBean("teacher1",Teacher.class);
		Teacher tea2 = ac.getBean("teacher1",Teacher.class);
		
		System.out.println(tea1);
		System.out.println(tea2);
	}
}
 