package others;

public class ThreadLocalTest1 {
	//public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(); //һ���޴���߳̿ռ�	
	//���ĳ�ʼֵ
	/*public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
		protected Integer initialValue() {
			return 200;
		};
	}; *///һ���޴���߳̿ռ�
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
			System.out.println(Thread.currentThread().getName()+"�õ���-->"+left);
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"��ʣ��-->"+threadLocal.get());
		}
	}
}
