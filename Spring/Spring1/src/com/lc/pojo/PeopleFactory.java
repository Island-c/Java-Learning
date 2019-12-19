package com.lc.pojo;

public class PeopleFactory {

	public People newInstance() {
		
		return new People(1,"测试");
	}
	
	public static People newInstance2() {
		
		return new People(2,"测试2");
	}
}
