package cn.lc.IO;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * ��ӡ��
 * 
 * @author Ice
 *
 */
public class PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("aa");
		ps.println(true);

		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt", false)), true); // true���Զ�ˢ����
		ps.println("��ӡ��");
		ps.println(true);

//		�ض���
		System.setOut(ps);

		System.out.println("change");

		ps.close();

		// �ض���ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("change");

	}
}
