package com.lc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lc.pojo.Airport;
import com.lc.service.AirportService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AirportService bean= ac.getBean("airportService",AirportService.class);
		
		List<Airport> list = bean.show();
		System.out.println(list);
		
//		String[] names = ac.getBeanDefinitionNames();
//		
//		for(String s : names) {
//			System.out.println(s);
//		}
	}
}
