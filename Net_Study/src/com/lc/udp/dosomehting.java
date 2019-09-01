package com.lc.udp;

public class dosomehting {
	public static void main(String[] args) {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new AAA().start();
		}

		
		
	}
	
}



class AAA extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true) {

			i++;
		}
	}
}