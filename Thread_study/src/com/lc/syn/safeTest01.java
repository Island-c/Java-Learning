package com.lc.syn;
/**线程安全：并发时保证数据正确性 效率尽可能高
 * synchronized
 * 同步方法
 * 同步块
 * @author Trail
 *
 */
public class safeTest01 {
		public static void main(String[] args) {
			//一份资源
			SafeWeb12306 web=new SafeWeb12306();
			System.out.println(Thread.currentThread().getName());
			//多个代理
			new Thread(web,"码畜").start();
			new Thread(web,"码农").start();
			new Thread(web,"码蟥").start();
		}
}
class SafeWeb12306 implements Runnable {

	private int ticketNums = 10;
	private boolean flag =true;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			test();
			try {
				Thread.sleep(50);//加了网络延迟 ，出现并发问题
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void test()
	{
		if(ticketNums <= 0 ) {
			flag=false;
			return;
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
	}
}