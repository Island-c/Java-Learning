package com.lc.syn;
/**�̰߳�ȫ������ʱ��֤������ȷ�� Ч�ʾ����ܸ�
 * synchronized
 * ͬ������
 * ͬ����
 * @author Trail
 *
 */
public class safeTest01 {
		public static void main(String[] args) {
			//һ����Դ
			SafeWeb12306 web=new SafeWeb12306();
			System.out.println(Thread.currentThread().getName());
			//�������
			new Thread(web,"����").start();
			new Thread(web,"��ũ").start();
			new Thread(web,"���").start();
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
				Thread.sleep(50);//���������ӳ� �����ֲ�������
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