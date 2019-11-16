package com.lc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletContextListener{

	
	/*监听session对象*/
	
	//创建session时 人数自增
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//获取ServletContext对象
		ServletContext sc = se.getSession().getServletContext();
		//获取在线人数统计的count
		int count = (int)sc.getAttribute("count");
		//更新application
		sc.setAttribute("count", ++count);
		System.out.println("count"+count);
		
	}
	
	//销毁session时人数自减
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//获取ServletContext对象
		ServletContext sc = se.getSession().getServletContext();
		//获取在线人数统计的count
		int count = (int)sc.getAttribute("count");

		//更新application
		sc.setAttribute("count", --count);
		System.out.println("count--："+count);
	}

	
	/*监听application对象*/
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//服务器启动：  初始化count
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//获取application
		ServletContext sc = sce.getServletContext();
		
		//在application对象存储变量统计在线人数
		
		sc.setAttribute("count", 0);
		System.out.println("application初始化");
	}

}
