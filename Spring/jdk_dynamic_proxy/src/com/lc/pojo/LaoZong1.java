package com.lc.pojo;

/**
 * cglib动态代理的原理 
 * 
 * 继承真实的类
 * 在super方法的基础上，添加前置处理和后置处理。
 * 
 * @author LC
 *
 */
public class LaoZong1 extends LaoZong{
	
	@Override
	public void chifan() {
		System.out.println("预约吃饭时间");
		super.chifan();
		System.out.println("备注");
		
	}
	

}
