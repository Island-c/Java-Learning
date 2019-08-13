package others;
/**
 * ����ģʽ ������ʽ��·�����ϼ��벢�����ƣ���֤�ڶ��̻߳����£��������һ������
 * 1. ������˽�л� --�� �����ⲿnew������
 * 2. �ṩ˽�еľ�̬����--���洢����ĵ�ַ
 * 3. �ṩ�����ľ�̬����--����ȡ����
 * @author Trail
 *
 */
public class DoubleCheckedLocking {
	//2���ṩ˽�еľ�̬����
	private static volatile DoubleCheckedLocking instance; //��volatile����ָ�����ţ�����instance��û�з��ظ����ã����Ѿ��������߳�get�ˡ�
	
	//������˽�л�
	private DoubleCheckedLocking() {
		
	}
	
	public static DoubleCheckedLocking getInstance(long time) {
		//�ٴμ��
		if(null == instance ) { //���ⲻ��Ҫ��ͬ��
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new DoubleCheckedLocking();
		}
		return instance;
	}
	public static DoubleCheckedLocking getInstance1() {
		//�ٴμ��
		if(null != instance ) { //���ⲻ��Ҫ��ͬ��
			return instance;
		}
		synchronized(DoubleCheckedLocking.class) {
			if(null == instance) {
				instance = new DoubleCheckedLocking();
				//newһ������ʱ��  1. ���ٿռ�  2 ��ʼ��������Ϣ 3.���ض����ַ������
			}
			return instance;
		}
	}
	
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			System.out.println(DoubleCheckedLocking.getInstance(500));
			
			
		});
		
		t.start();
		System.out.println(DoubleCheckedLocking.getInstance(1000));
	}
	
}
