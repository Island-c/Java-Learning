package com.lc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session = factory.openSession();
		
//		List< > list = session.selectList("a.b.selAll");
//		for(Flower flower:list) {
//			System.out.println(flower.toString());
//			
//		}
		
//		int count =session.selectOne("a.b.selById");
//		System.out.println(count);
		
		
 
		
		session.close();
	}
}
