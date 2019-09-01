package com.lc.loc;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * IP��ַ
 * @author Trail
 * IP:��λһ���ڵ�:�������·�ɡ�ͨѶ�豸��
 * InetAddress: �����̬����
 * 1��getLocalHost:����
 * 2��getByName:��������DNS |  IP��ַ -->IP
 * 
 * ������Ա����
 * 1��getHostAddress: ���ص�ַ
 * 2��getHostName:���ؼ������
 */
public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����  �� ����
		InetAddress addr= InetAddress.getLocalHost(); 
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName()); //�������
		
		//���������õ�InetAddress����
		addr = InetAddress.getByName("www.shsxt.com"); 
		System.out.println(addr.getHostAddress());  //���� shsxt��������ip:
		System.out.println(addr.getHostName());  //�����www.shsxt.com
		
		//����ip�õ�InetAddress����
		addr = InetAddress.getByName("123.56.138.186"); 
		System.out.println(addr.getHostAddress());  //���� shsxt��ip:123.56.138.176
		System.out.println(addr.getHostName());  //���ip������������������IP�� ַ�����ڻ�DNS���������������IP��ַ��������ӳ�䣬

		
		
	}

	
	
}
