package cooperation;
/**
 * �źŵ� ������־λ
 * @author Trail
 *
 */
public class CoTest1 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}

//������  ��Ա
class Player extends Thread{
	Tv tv;

	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20 ;i++) {
			if(i%2 ==0) {
				this.tv.play("������");
			}else {
				this.tv.play("����");
			}
		}
	}
	
}
//������  ����
class Watcher extends Thread{
	Tv tv;

	public Watcher(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20 ;i++) {
			tv.watch();
		}
	}
}

//ͬһ����Դ ����
class Tv{
	String voice;
	//�źŵ�
	//t ��Ա���� ���ڵȴ�  F���ڹۿ� ��Ա�ȴ�
	boolean flag= true;
	
	public synchronized void play(String voice) {
		
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������-->"+voice);
		this.voice = voice;
		
		this.notifyAll();
		this.flag= ! this.flag;
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������-->"+voice);
		
		this.notifyAll();
		this.flag=!this.flag;
	}
	
	
}