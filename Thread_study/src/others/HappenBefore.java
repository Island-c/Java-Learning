package others;
/**
 * 指令重排
 * @author Trail
 *
 */
public class HappenBefore {
	private static int a =0;
	private static boolean flag = false;
	
	public static void main(String[] args) throws InterruptedException {
		//线程1 读取数据
		Thread t1 = new Thread(()->{
			a=1;
			flag=true;
			System.out.println("t1");
		});
		
		
		//线程2 更改数据.
		Thread t2 = new Thread(()->{
			if(flag) {
				a*=1;
			}
			if(a==0) {
				System.out.println("happen before"+a);
			}
		});
		
		t1.start();
		t2.start();
		
		//合并线程
		t1.join();
		t2.join();
	}
}
