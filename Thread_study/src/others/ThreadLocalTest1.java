package others;

public class ThreadLocalTest1 {
	//public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(); //一个巨大的线程空间	
	//更改初始值
	/*public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
		protected Integer initialValue() {
			return 200;
		};
	}; *///一个巨大的线程空间
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(new MyRun()).start();
		}
	}
	
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Integer left = threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"得到了-->"+left);
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
		}
	}
}
