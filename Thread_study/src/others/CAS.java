package others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS比较并交换
 * @author Trail
 *
 */
public class CAS {
	private static AtomicInteger stock = new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0 ; i<5 ;i++) {
			new Thread(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer left = stock.decrementAndGet();//操作
				if(left<1) {
					System.out.println("抢完了");
					return ;
				}
					System.out.println(Thread.currentThread().getName()+"-->抢到了一件"+"-->>还剩"+left);		
			}).start();
		}
	}
}
