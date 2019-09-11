package cn.lc.IO;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 打印流
 * 
 * @author Ice
 *
 */
public class PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println("aa");
		ps.println(true);

		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt", false)), true); // true是自动刷新流
		ps.println("打印流");
		ps.println(true);

//		重定向
		System.setOut(ps);

		System.out.println("change");

		ps.close();

		// 重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("change");

	}
}
