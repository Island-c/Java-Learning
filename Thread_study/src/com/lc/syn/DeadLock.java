package com.lc.syn;
/**
 
 * @author Trail
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		Markup g1=new Markup(1,"啊");
		Markup g2=new Markup(0,"哈");
		g1.start();
		g2.start();
	}
}

class Lipstick{
}
class Mirror{	
}

class Markup extends Thread{
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	int choice;
	String girl;
	
	public Markup(int choice,String girl) {
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//化妆
		markup();
	}
	
	private void markup() {
		if(choice==0){
			synchronized(lipstick) {
				//获得口红的锁
				System.out.println(this.girl+"获得口红");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized(mirror) {
				System.out.println(this.girl+"照镜子");
			}
		}else {
			synchronized(mirror) {
				System.out.println(this.girl+"照镜子");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			synchronized(lipstick) {
				System.out.println(this.girl+"获得口红");
			}
		}
	}
	
}
