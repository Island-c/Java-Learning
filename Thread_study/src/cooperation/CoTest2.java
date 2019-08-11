package cooperation;

public class CoTest2 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start(); 
		new Consumer(container).start(); 
	}
}

//������
class Productor extends Thread{
	SynContainer container;
	
	public Productor(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//����
		for(int i=0;i<100;i++) {
			System.out.println("����-->"+i+"����ͷ");
			container.push( new Steamedbun(i));
		}
	}
}

//������
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//����
		for(int i=0; i<100; i++) {
			System.out.println("����-->"+i+"����ͷ");
			container.pop();
		}
	}
}

//������
class SynContainer{
	int count=0; //������
	Steamedbun[] buns = new Steamedbun[10];//����
	
	//��
	public synchronized void push(Steamedbun bun) {
		if(count == buns.length) {
			try {
				this.wait(); //������ ������֪ͨ��������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		buns[count++]=bun;
	}
	//ȡ
	public synchronized Steamedbun pop() {
		if(count == 0) {
			try {
				this.wait(); //�߳������� ������֪ͨ��������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return buns[--count];
	}
}

//��ͷ
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		this.id = id;
	}
	
}