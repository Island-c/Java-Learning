package com.lc.thread;

public class Web12306 implements Runnable {

	private int ticketNums = 99;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(ticketNums < 0 )
				break;
			try {
				Thread.sleep(200);//���������ӳ� �����ֲ�������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

		}
	}
	
	public static void main(String[] args) {
		//һ����Դ
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		//�������
		new Thread(web,"����").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}
