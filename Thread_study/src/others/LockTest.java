package others;
/**
 * 不可重入锁 不 可以连续使用
 * @author Trail
 *
 */
public class LockTest {
	ReLock lock=new ReLock();
	
	public void a () throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
	}
	public void doSomething() throws InterruptedException {
		//不可重入
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}

	public static void main(String[] args) throws InterruptedException {
		LockTest test=new LockTest();
		test.a();

		test.doSomething();
		
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
	}
}

class Lock{
	//是否占用
	private boolean isLocked = false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked=true;	
	}
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}

class ReLock{
	//是否占用
	private boolean isLocked = false;
	private Thread lockedBy=null;//存储线程
	private int holdCount=0;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(isLocked && lockedBy != Thread.currentThread()) {
			wait();
		}
		isLocked=true;	
		lockedBy=t;
		holdCount++;
	}
	public int getHoldCount() {
		return holdCount;
	}

	public synchronized void unlock() {
		if(Thread.currentThread() == lockedBy) {
			holdCount--;
			if(holdCount == 0) {
				isLocked=false;
				notify();
				lockedBy=null;
			}
		}

	}
}