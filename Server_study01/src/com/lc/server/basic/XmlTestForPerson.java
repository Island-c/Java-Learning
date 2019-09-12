package com.lc.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlTestForPerson {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// sax解析
		// 1 获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3.加载文档 注册处理器
		// 4。 编写处理器
		PersonHandler handler = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/lc/server/basic/p.xml"),
				handler);

		List<Person> persons = handler.getPersons();

		for (Person p : persons) {
			System.out.println(p.getName() + "---" + p.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		persons = new ArrayList<Person>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-genejrated method stub
		System.out.println(qName + "-->解析开始");
		if (null != qName) {
			tag = qName; // 存储标签名
			if (tag.equals("person")) {
				System.out.println(tag);
				person = new Person();

			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName + "-->解析结束");
		if (null != qName) {
			if (qName.equals("person")) {
				persons.add(person);
			}
			tag = null;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(ch, start, length).trim();
		if (null != tag) {// 处理空
			if (tag.equals("name")) {
				person.setName(contents);
			} else if (tag.equals("age")) {
				if (contents.length() > 0) {
					person.setAge(Integer.valueOf(contents));
				}
			}
		}

	}

	public List<Person> getPersons() {
		return persons;
	}

}
