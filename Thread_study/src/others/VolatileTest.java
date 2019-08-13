package others;

public class VolatileTest {
	private volatile static int num =0; //加了volatile，就算满cpu，也要读取改动的数据。
	//private static int num =0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num ==0 ) {
				//占用cpu
			}
		}).start();
		Thread.sleep(1000);
		num=1;
	}
}
