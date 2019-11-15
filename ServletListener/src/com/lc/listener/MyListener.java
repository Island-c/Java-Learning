package com.lc.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletRequestListener, ServletRequestAttributeListener, HttpSessionListener,
		HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener {

	/*--------------------Request------------------------------------------------------------------------*/
	// 销毁
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("request:我被销毁了");
	}

	// 初始化
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("request:我被创建了");
	}

	// 添加
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中添加了一条数据:" + srae.getName() + ":" + srae.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中删除了一条数据:" + srae.getName() + ":" + srae.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中修改了一条数据:" + srae.getName() + ":" + srae.getValue());
	}

	/*--------------------Session------------------------------------------------------------------------*/
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建");

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session销毁");
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session添加:" + se.getName() + ":" + se.getValue());

	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session删除" + se.getName() + ":" + se.getValue());

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session修改" + se.getName() + ":" + se.getValue());
	}


	/*----------------ServletContext----------------------------------------------------------------*/
	
	

	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
		System.out.println("application添加数据："+scab.getName()+":"+scab.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("application删除数据："+scab.getName()+":"+scab.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("application修改数据："+scab.getName()+":"+scab.getValue());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application销毁");
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application创建");
	}
	
}
