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
	// ����
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("request:�ұ�������");
	}

	// ��ʼ��
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("request:�ұ�������");
	}

	// ���
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request�������һ������:" + srae.getName() + ":" + srae.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request��ɾ����һ������:" + srae.getName() + ":" + srae.getValue());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request���޸���һ������:" + srae.getName() + ":" + srae.getValue());
	}

	/*--------------------Session------------------------------------------------------------------------*/
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session����");

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session����");
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session���:" + se.getName() + ":" + se.getValue());

	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("sessionɾ��" + se.getName() + ":" + se.getValue());

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session�޸�" + se.getName() + ":" + se.getValue());
	}


	/*----------------ServletContext----------------------------------------------------------------*/
	
	

	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
		System.out.println("application������ݣ�"+scab.getName()+":"+scab.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("applicationɾ�����ݣ�"+scab.getName()+":"+scab.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("application�޸����ݣ�"+scab.getName()+":"+scab.getValue());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application����");
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application����");
	}
	
}
