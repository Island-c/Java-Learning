package others;

public class VolatileTest {
	private volatile static int num =0; //����volatile��������cpu��ҲҪ��ȡ�Ķ������ݡ�
	//private static int num =0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			while(num ==0 ) {
				//ռ��cpu
			}
		}).start();
		Thread.sleep(1000);
		num=1;
	}
}
