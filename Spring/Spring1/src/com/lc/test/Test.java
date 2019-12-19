package com.lc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lc.pojo.People;
import com.lc.pojo.PeopleFactory;

public class Test {

	public static void main(String[] args) {
//		People peo = new People();
		
		ApplicationContext ac = new  ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		People peo =ac.getBean("peo",People.class);
//		System.out.println(peo);
//		
//		
//		String[] names = ac.getBeanDefinitionNames();
//		for(String n : names) {
//			System.out.println(n);
//		}
		
//		PeopleFactory factory =new PeopleFactory();
//		factory.newInstance();

		People people = ac.getBean("peo2",People.class);
		System.out.println(people);
		
	}
}
