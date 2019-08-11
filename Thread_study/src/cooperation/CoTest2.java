package cooperation;

public class CoTest2 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start(); 
		new Consumer(container).start(); 
	}
}

//生产者
class Productor extends Thread{
	SynContainer container;
	
	public Productor(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//生产
		for(int i=0;i<100;i++) {
			System.out.println("生产-->"+i+"个馒头");
			container.push( new Steamedbun(i));
		}
	}
}

//消费者
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//消费
		for(int i=0; i<100; i++) {
			System.out.println("消费-->"+i+"个馒头");
			container.pop();
		}
	}
}

//缓冲区
class SynContainer{
	int count=0; //计数器
	Steamedbun[] buns = new Steamedbun[10];//容器
	
	//存
	public synchronized void push(Steamedbun bun) {
		if(count == buns.length) {
			try {
				this.wait(); //阻塞， 消费者通知生产则解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		buns[count++]=bun;
	}
	//取
	public synchronized Steamedbun pop() {
		if(count == 0) {
			try {
				this.wait(); //线程阻塞， 生产者通知消费则解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return buns[--count];
	}
}

//馒头
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		this.id = id;
	}
	
}