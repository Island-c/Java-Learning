package com.lc.threadState;
/**
 * �ػ��߳���Ϊ�û��̷߳���ġ� JVMֹͣ���õȴ��ػ��߳�ִ����ϡ� 
 * Ĭ������£������̶߳����û��̣߳�jvm�ȴ������û��߳�ִ����ϲŻ�ֹͣ��
 * @author Trail
 *
 */
public class DeamonTest {
	public static void main(String[] args) {
		God god=new God();
		You you=new You();
		Thread t = new Thread(god);
		t.setDaemon(true);//���û��̵߳���Ϊ�ػ��߳�
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
