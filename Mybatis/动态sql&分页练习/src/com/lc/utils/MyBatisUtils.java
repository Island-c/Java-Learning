package com.lc.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
	
	static {
		InputStream is=null ;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
		
	}
	
	
	/**
	 * 获取该线程独一份的session。  如果还没有创建  就先创建再获取
	 * @return
	 */
	public static SqlSession getSession() {
		
		SqlSession session = tl.get();
		if(session == null) {
			tl.set(factory.openSession());
		}
		
		return tl.get();
		
	}
	
	public static void closeSession() {
		SqlSession session =tl.get();
		if(session != null) {
			session.close();
		}
		tl.set(null);
	}
	
	
	
}
