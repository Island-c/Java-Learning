package com.lc.threadState;
/**
 * ��ֹ�߳�
 * 1.����ִ�����
 * 2. �ⲿ���� �������ʶ
 * @author Trail
 *
 */
public class TerminateThread implements Runnable{
	private boolean flag = true;
	private String name;
	public TerminateThread(String n)
	{
		name =n;
	}
	
	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread ("����");
		new Thread(tt).start();
		
		for(int i=0; i<=99; i++) {
			System.out.println("main-->"+i);
			if( i==88) {
				tt.terminate();  //�̵߳���ֹ
				System.out.println("over");
				break;
			}
				
			
		}
	}

	@Override
	public void run() {
		int i=0;
		// TODO Auto-generated method stub
		while (flag) {
			System.out.println(name+"-->"+i++);
		}
	}
	
	public void terminate() {
		this.flag = false;
	}
	

	
}
