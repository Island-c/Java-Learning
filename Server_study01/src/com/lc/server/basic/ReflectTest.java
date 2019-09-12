package com.lc.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java中各种结构（方法、属性、构造器、类名）映射成一个个java对象 
 * 1. 获取class对象
 * 
 * @author Ice
 *
 */
public class ReflectTest {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// 三种方式获取对象
		// 1. 对象.getclass()
		Iphone iphone = new Iphone();
		Class clz = new Iphone().getClass();

		// 2. 类.class
		clz = Iphone.class;

		// 3. Class.forName("包名.类名");
		clz = Class.forName("com.lc.server.basic.Iphone");

		// 创建对象
		Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();
		System.out.println(iphone2);

	}

}

class Iphone {
	public Iphone() {

	}
}
