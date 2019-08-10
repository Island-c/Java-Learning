package com.lc.thread;



/**
 * 模拟龟兔赛跑
 * @author Trail
 *
 */
public class Racer implements Runnable{
	private String winner;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int steps=1 ; steps <=100 ; steps ++) {
			if(steps%10==0  && Thread.currentThread().getName() .equals("rabbit")) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//判断比赛是否结束
			boolean flag = gameOver(steps);
			if(flag) {
				break;
			}
				
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
		}
	}
	
	private boolean gameOver(int steps) {
		if (winner != null) {
			return true;
		}else {
			if(steps ==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner==>>"+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}
}
