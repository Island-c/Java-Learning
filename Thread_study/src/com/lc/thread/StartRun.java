package com.lc.thread;
/**�����̵߳ļ��ַ���
 * 
 * @author Trail
 *
 */
public class StartRun implements Runnable{

	public void run()
	{
		for(int i=0; i<20 ;++i) {
			System.out.println("����");
		}
	}
	
	public static void main(String[] args) {
		//ʵ�������
		//StartRun s=new StartRun();
		//���������
		//new Thread(s).start();
		
		new Thread(new StartRun()).start(); //��������
		
		for(int i=0; i<20 ;++i) {
			System.out.println("coding");
		}
		
	}
}

