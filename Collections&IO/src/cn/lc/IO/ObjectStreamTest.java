package cn.lc.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ������
 * 
 * @author Ice
 *
 */
public class ObjectStreamTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//д��
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt")); //������д����baos����
		//������������+����
		oos.writeUTF("������");
		oos.writeBoolean(false);
		oos.writeChar('a');
		//д������
		oos.writeObject(new Date());
		Employee emp= new Employee("�ǺǺ�",400);
		oos.writeObject(emp);
		oos.flush();
		oos.close();

		//��ȡ
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("obj.txt"))));
		String msg = ois.readUTF();
		boolean flag = ois.readBoolean();
		char ch= ois.readChar();
		Object data=ois.readObject();
		Object employee = ois.readObject();
		System.out.println(msg);
		if(data instanceof Date) {
			Date d= (Date)data;
			System.out.println(d.getTime());
		}
		if(employee instanceof Employee) {
			Employee e= (Employee)employee;
			System.out.println(e.getName());
		}
	}
	
	
	//java bean  ���ڷ�װ����
	static class Employee implements java.io.Serializable{
		private String name;
		private double salary;
		public Employee(String name, double salary) {
			this.name = name;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
	}
	
}
