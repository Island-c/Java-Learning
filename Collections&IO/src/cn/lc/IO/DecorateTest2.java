package cn.lc.IO;
/**
 * ģ�⿧��
 * 1.�����������Ҫװ�εĳ�����󣨽ӿ� �� �����ࣩ
 * 2.���������Ҫװ�εĶ���
 * 3.����װ���ࣺ�����˶Գ������������ �� װ���߹��з���
 * 4.����װ���ࣺ ��װ�εĶ���
 * @author Trail
 *
 */
public class DecorateTest2 {
	public static void main(String[] args) {
		Drink coffee=new Coffee();
		
		Drink suger=new Suger(coffee);//װ��
		System.out.println(suger.info() + "->>" + suger.cost());
		
		Drink milk=new Milk(coffee);//װ��
		System.out.println(milk.info() + "->>" + milk .cost());
		
		milk = new Milk(suger);//װ��
		System.out.println(milk.info() + "->>" + milk .cost());
	}
}
//����װ����
class Suger extends Decorate{
	public Suger(Drink drink)
	{
		 super(drink);
	}
	
	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"����������";
	}
	
}
class Milk extends Decorate{
	public Milk(Drink drink)
	{
		 super(drink);
	}
	
	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"������ţ��";
	}
	
}


//����װ����
abstract class Decorate implements Drink{
	private Drink drink;
	public Decorate(Drink drink)
	{
		this.drink = drink;
	}
	
	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
	
}

//�������
class Coffee implements Drink{
	private String name= "ԭζ����";
	
	@Override
	public double cost() {
		return 10;
	}
	@Override
	public String info() {
		return name;
	}
}

//�������
interface Drink{
	double cost();
	String info();
	
}
