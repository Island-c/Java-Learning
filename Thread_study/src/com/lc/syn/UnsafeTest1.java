package com.lc.syn;

public class UnsafeTest1 {
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
class Web12306 implements Runnable {

	private int ticketNums = 10;
	private boolean flag =true;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			test();
		}
	}
	public void test()
	{
		if(ticketNums < 0 ) {
			flag=false;
			return;
		}

		try {
			Thread.sleep(50);//���������ӳ� �����ֲ�������
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

	}
}