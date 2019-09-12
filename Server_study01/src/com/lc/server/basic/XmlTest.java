package com.lc.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ����SAX����
 * 
 * @author Ice
 *
 */
public class XmlTest {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// sax����
		// 1 ��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3.�����ĵ� ע�ᴦ����
		// 4�� ��д������
		PHandler handler = new PHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/lc/server/basic/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ���ʼ");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-genejrated method stub
		System.out.println(qName+"-->������ʼ");
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName+"-->��������");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ�����");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(ch ,start,length);
		if(contents.length() >0 ) {
			System.out.println("����Ϊ-->"+contents);			
		}else {
			System.out.println("����Ϊ��");
		}
	}
}
