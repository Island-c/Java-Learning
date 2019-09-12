package com.lc.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��java�и��ֽṹ�����������ԡ���������������ӳ���һ����java���� 
 * 1. ��ȡclass����
 * 
 * @author Ice
 *
 */
public class ReflectTest {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// ���ַ�ʽ��ȡ����
		// 1. ����.getclass()
		Iphone iphone = new Iphone();
		Class clz = new Iphone().getClass();

		// 2. ��.class
		clz = Iphone.class;

		// 3. Class.forName("����.����");
		clz = Class.forName("com.lc.server.basic.Iphone");

		// ��������
		Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();
		System.out.println(iphone2);

	}

}

class Iphone {
	public Iphone() {

	}
}
