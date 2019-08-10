package com.lc.thread;
/**创建线程的几种方法
 * 
 * @author Trail
 *
 */
public class StartRun implements Runnable{

	public void run()
	{
		for(int i=0; i<20 ;++i) {
			System.out.println("听歌");
		}
	}
	
	public static void main(String[] args) {
		//实现类对象
		//StartRun s=new StartRun();
		//代理类对象
		//new Thread(s).start();
		
		new Thread(new StartRun()).start(); //匿名引用
		
		for(int i=0; i<20 ;++i) {
			System.out.println("coding");
		}
		
	}
}

