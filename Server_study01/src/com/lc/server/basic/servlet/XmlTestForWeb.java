package com.lc.server.basic.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlTestForWeb {
	public static void main(String[] args) throws Exception {
		// sax解析
		// 1 获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3.加载文档 注册处理器
		// 4。 编写处理器
		WebHandler handler = new WebHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/lc/server/basic/servlet/web.xml"),
				handler);

		//获取数据
		WebContext context = new WebContext(handler.getEntitys(),handler.getMappings());
		//假设输入/login
		String className = context.getClz("/login");
		Class clz = Class.forName(className);
		Servlet servlet = (Servlet)clz.getConstructor().newInstance();
		//System.out.println(servlet);
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping ;
	private String tag;
	private boolean isMapping = false;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		entitys = new ArrayList<Entity>();
		mappings = new ArrayList<Mapping>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-genejrated method stub
		System.out.println(qName + "-->解析开始");
		if (null != qName) {
			tag = qName; // 存储标签名
			if (tag.equals("servlet")) {
				entity = new Entity();
				isMapping =false;
			}else if(tag.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping = true;
			}
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(ch, start, length).trim();
		if (null != tag) {// 处理空
			if(isMapping) {
				//操作mapping
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern"))
				{
					mapping.addPattern(contents);
//					System.out.println(contents);
				}
				
			}else {
				//操作servlet
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class"))
				{
					entity.setClz(contents);
				}
			}
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
//		System.out.println(qName + "-->解析结束");
		if (null != qName) {
			if (qName.equals("servlet")) {
				entitys.add(entity);
			}else if(qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag=null;
	}





	public List<Entity> getEntitys() {
		return entitys;
	}


	public List<Mapping> getMappings() {
		return mappings;
	}

}
