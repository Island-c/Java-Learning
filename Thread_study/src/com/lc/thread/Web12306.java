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
				Thread.sleep(200);//加了网络延迟 ，出现并发问题
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

		}
	}
	
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
