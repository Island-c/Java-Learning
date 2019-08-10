package com.lc.thread;
/**
 * 静态代理
 * 1。真实角色
 * 2.代理角色
 * @author Trail
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
		//同new Thread(线程对象).start();  
	}
}

interface Marry{
	void happyMarry();
}

class You implements Marry{
	@Override
	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and 嫦娥奔月了");
	}
}

class WeddingCompany implements Marry{

	//真实角色
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
		System.out.println("布置猪窝");
	}
	private void after() {
		System.out.println("闹洞房");
	}
	
	
}
