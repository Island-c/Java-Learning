package com.lc.pojo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MiShu implements MethodInterceptor{

	//arg0 : 生成的子类对象
	// arg1 ： 父类被代理的方法 （真实方法
	// arg2： 方法的参数列表
	//arg3 : 生成的代理类 （真实方法的子类 
    /**
     * @param proxy：代理对象引用
     * @param method：目标对象方法（通过它可以访问目标对象）
     * @param args：传递给目标对象的参数
     * @MethodProxy methodProxy：代理对象的方法
     * @return 返回值
     * @throws Throwable
     */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println(arg0.getClass());
		
		System.out.println("预约时间");
		
		//arg1.invoke(obj, args)  调用子类重写的方法
		Object result = arg1.invoke(arg0, arg2);
//		Object result = arg3.invokeSuper(arg0, arg2);
		
		//arg3.invokeSuper(arg0, arg1)  
	
		System.out.println("备注");
		
		return result;
	}
}
