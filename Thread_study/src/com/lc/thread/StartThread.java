package com.lc.thread;
/**创建线程的几种方法
 * 
 * @author Trail
 *
 */
public class StartThread extends Thread{

	public void run()
	{
		for(int i=0; i<20 ;++i) {
			System.out.println("听歌");
		}
	}
	
	public static void main(String[] args) {
		StartThread s=new StartThread();
		s.start();
		
		for(int i=0; i<20 ;++i) {
			System.out.println("coding");
		}
		
	}
}

