package com.lc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ģ���������
 * @author Trail
 *
 */
public class CRacer2 implements Callable<Integer>{
	private String winner;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for(int steps=1 ; steps <=100 ; steps ++) {
			if(steps%10==0  && Thread.currentThread().getName() .equals("rabbit")) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//�жϱ����Ƿ����
			boolean flag = gameOver(steps);
			if(flag) {
				return steps;
			}
				
			System.out.println(Thread.currentThread().getName()+"-->"+steps);
		}
		return null;
	}
	
	private boolean gameOver(int steps) {
		if (winner != null) {
			return true;
		}else {
			if(steps ==100) {
				winner=Thread.currentThread().getName();
				System.out.println("winner==>>"+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer2 racer=new CRacer2();
		
		//����ִ�з���
		ExecutorService ser=Executors.newFixedThreadPool(2);
		//�ύִ��
		Future<Integer> result1=ser.submit(racer);
		Future<Integer> result2=ser.submit(racer);
		//��ȡ���
		Integer r1=result1.get();
		Integer r2=result2.get();
		System.out.println(r1 +"--->"+ r2);
		//�رշ���
		ser.shutdownNow();
		

	}
}
