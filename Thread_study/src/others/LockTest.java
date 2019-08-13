package others;
/**
 * ���������� �� ��������ʹ��
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
		//��������
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
	//�Ƿ�ռ��
	private boolean isLocked = false;
	//ʹ����
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
	//�Ƿ�ռ��
	private boolean isLocked = false;
	private Thread lockedBy=null;//�洢�߳�
	private int holdCount=0;
	//ʹ����
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