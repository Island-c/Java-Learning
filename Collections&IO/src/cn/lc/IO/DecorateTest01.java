package cn.lc.IO;
/**
 * ʵ�ַŴ����������ķŴ���
 * @author Trail
 *
 */
public class DecorateTest01 {
	public static void main(String[] args) {
	Person p = new Person();
	p.say();
	
	//װ��
	Amplifier am=new Amplifier(p);
	am.say();
}
}

interface Say
{
	void say();
}

class Person implements Say{
	//���� 
	private int voice = 10;
	
	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("�˵�����Ϊ"+this.getVoice());
	}
	
}

//�Ŵ���
class Amplifier implements Say{
	private Person p;
	Amplifier(Person p)
	{
		this.p=p;
	}
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("�˵�����Ϊ"+p.getVoice()*100);
		System.out.println("����");
	}
	
}
