package com.lc.threadState;
/**
 * 守护线程是为用户线程服务的。 JVM停止不用等待守护线程执行完毕。 
 * 默认情况下，所有线程都是用户线程，jvm等待所有用户线程执行完毕才会停止。
 * @author Trail
 *
 */
public class DeamonTest {
	public static void main(String[] args) {
		God god=new God();
		You you=new You();
		Thread t = new Thread(god);
		t.setDaemon(true);//将用户线程调整为守护线程
		t.start();
		new Thread(you).start();
	}
}

class You implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<365*100; i++) {
			System.out.println("happy life......");
		}
		System.out.println("oooooo.....");
	}
}

class God implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;true;) {
			System.out.println("bless you...");
		}
	}
}
