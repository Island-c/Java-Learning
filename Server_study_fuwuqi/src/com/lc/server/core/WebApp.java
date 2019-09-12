package com.lc.server.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
	private static WebContext context;
	static {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2从解析工厂获取解析器
			SAXParser parse = factory.newSAXParser();
			// 3.加载文档 注册处理器
			// 4。 编写处理器
			WebHandler handler = new WebHandler();
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),
					handler);
			context = new WebContext(handler.getEntitys(),handler.getMappings());
		}catch(Exception e) {
			System.out.println("解析配置文件错误");
		}
		
		
	}
	
	//According Url get config's Servlet
	public static Servlet getServletFromUrl(String url) {
		//获取数据
		
		//假设输入/login
		String className = context.getClz("/"+url);
		System.out.println(className);
		try {
			if(className != null) {
				Class clz = Class.forName(className);
				Servlet servlet = (Servlet)clz.getConstructor().newInstance();			
				return servlet;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

