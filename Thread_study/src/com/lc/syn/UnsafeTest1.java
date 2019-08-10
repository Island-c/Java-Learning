package com.lc.syn;

public class UnsafeTest1 {
		public static void main(String[] args) {
			//一份资源
			Web12306 web=new Web12306();
			System.out.println(Thread.currentThread().getName());
			//多个代理
			new Thread(web,"码畜").start();
			new Thread(web,"码农").start();
			new Thread(web,"码蟥").start();
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
			Thread.sleep(50);//加了网络延迟 ，出现并发问题
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

	}
}