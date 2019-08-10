package com.lc.thread;
/**
 * ��̬����
 * 1����ʵ��ɫ
 * 2.�����ɫ
 * @author Trail
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		//ͬnew Thread(�̶߳���).start();  
	}
}

interface Marry{
	void happyMarry();
}

class You implements Marry{
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and �϶�����");
	}
}

class WeddingCompany implements Marry{

	//��ʵ��ɫ
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		ready();
		this.target.happyMarry();
		after();
	}
	
	private void ready() {
		System.out.println("��������");
	}
	private void after() {
		System.out.println("�ֶ���");
	}
	
	
}
