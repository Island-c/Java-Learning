package com.lc.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析SAX流程
 * 
 * @author Ice
 *
 */
public class XmlTest {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// sax解析
		// 1 获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3.加载文档 注册处理器
		// 4。 编写处理器
		PHandler handler = new PHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/lc/server/basic/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档开始");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-genejrated method stub
		System.out.println(qName+"-->解析开始");
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->解析结束");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档结束");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(ch ,start,length);
		if(contents.length() >0 ) {
			System.out.println("内容为-->"+contents);			
		}else {
			System.out.println("内容为空");
		}
	}
}
