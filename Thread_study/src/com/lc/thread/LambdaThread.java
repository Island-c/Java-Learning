package com.lc.thread;
/**lambda���ʽ ���̵߳�ʹ�ã�ֻ��һ�ε��̣߳�
 * 
 * @author Trail
 *
 */
public class LambdaThread {
	//�ڲ���
	static class Test implements Runnable{
		public void run()
		{
			for(int i=0; i<20 ;++i) {
				System.out.println("����");
			}
		}
	}

	public static void main(String[] args) {
		//ʵ�������
		//StartRun s=new StartRun();
		//���������
		//new Thread(s).start();
		
		//new Thread(new Test()).start(); //��������
		
		//�ֲ��ڲ���
		class Test2 implements Runnable{
			public void run()
			{
				for(int i=0; i<20 ;++i) {
					System.out.println("����");
				}
			}
		}
		//new Thread(new Test2()).start(); //��������
		
		//�����ڲ��� ����������ӿڻ��߸���
		new Thread(new Runnable() {
			public void run()
			{
				for(int i=0; i<20 ;++i) {
					System.out.println("����");
				}
			}
		}).start();
		
		
		//jdk8�� lambda
		new Thread(()->{
			for(int i=0; i<20 ;++i) {
				System.out.println("����");
			}
		}).start();
		
		for(int i=0; i<20 ;++i) {
			System.out.println("coding");
		}
		
	}
}

