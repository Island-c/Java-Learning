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
		// sax����
		// 1 ��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3.�����ĵ� ע�ᴦ����
		// 4�� ��д������
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
		System.out.println(qName + "-->������ʼ");
		if (null != qName) {
			tag = qName; // �洢��ǩ��
			if (tag.equals("person")) {
				System.out.println(tag);
				person = new Person();

			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(qName + "-->��������");
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
		if (null != tag) {// �����
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
