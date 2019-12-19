package com.lc.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MiShu implements InvocationHandler{
	private LaoZong laozong = new LaoZong();
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("预约时间");
		Object result = method.invoke(laozong, args);  //用反射方式调用真实对象
		System.out.println("记录");
		return result;
	}
}
