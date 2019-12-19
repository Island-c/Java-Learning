package com.lc.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		String[] names = ac.getBeanDefinitionNames();
//		for(String n : names) {
//			System.out.println(n);
//		}
//		
		
		Demo demo = ac.getBean("demo", Demo.class);
		try {
			demo.demo1("a",1);
			//demo.demo1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}
