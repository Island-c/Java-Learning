package others;
/**
 * 单例模式 ：懒汉式套路基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1. 构造器私有化 --》 避免外部new构造器
 * 2. 提供私有的静态属性--》存储对象的地址
 * 3. 提供公共的静态方法--》获取属性
 * @author Trail
 *
 */
public class DoubleCheckedLocking {
	//2，提供私有的静态属性
	private static volatile DoubleCheckedLocking instance; //加volatile避免指令重排，导致instance还没有返回给引用，就已经被其他线程get了。
	
	//构造器私有化
	private DoubleCheckedLocking() {
		
	}
	
	public static DoubleCheckedLocking getInstance(long time) {
		//再次检测
		if(null == instance ) { //避免不必要的同步
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
		//再次检测
		if(null != instance ) { //避免不必要的同步
			return instance;
		}
		synchronized(DoubleCheckedLocking.class) {
			if(null == instance) {
				instance = new DoubleCheckedLocking();
				//new一个对象时：  1. 开辟空间  2 初始化对象信息 3.返回对象地址给引用
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
