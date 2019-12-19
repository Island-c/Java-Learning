package com.lc.pojo;

import java.lang.reflect.Proxy;

public class Women {

	public static void main(String[] args) {
		MiShu mishu = new MiShu();
		//第一个参数： 反射时使用的类加载器
		//第二个参数：Proxy需要实现什么接口
		//第三个参数：通过接口对象调用方法时，需要调用哪个类的invoke方法
		Gongneng gongneng = (Gongneng)Proxy.newProxyInstance(Women.class.getClassLoader(),new Class[] {Gongneng.class},mishu);
		gongneng.chifan();
	}
}
