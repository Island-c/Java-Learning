package com.lc.thread;
/**lambda表达式 简化线程的使用（只用一次的线程）
 * 
 * @author Trail
 *
 */
public class LambdaThread {
	//内部类
	static class Test implements Runnable{
		public void run()
		{
			for(int i=0; i<20 ;++i) {
				System.out.println("听歌");
			}
		}
	}

	public static void main(String[] args) {
		//实现类对象
		//StartRun s=new StartRun();
		//代理类对象
		//new Thread(s).start();
		
		//new Thread(new Test()).start(); //匿名引用
		
		//局部内部类
		class Test2 implements Runnable{
			public void run()
			{
				for(int i=0; i<20 ;++i) {
					System.out.println("听歌");
				}
			}
		}
		//new Thread(new Test2()).start(); //匿名引用
		
		//匿名内部类 （必须借助接口或者父类
		new Thread(new Runnable() {
			public void run()
			{
				for(int i=0; i<20 ;++i) {
					System.out.println("听歌");
				}
			}
		}).start();
		
		
		//jdk8简化 lambda
		new Thread(()->{
			for(int i=0; i<20 ;++i) {
				System.out.println("听歌");
			}
		}).start();
		
		for(int i=0; i<20 ;++i) {
			System.out.println("coding");
		}
		
	}
}

