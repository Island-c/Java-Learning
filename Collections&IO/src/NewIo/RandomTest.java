package NewIo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {
	public static void main(String[] args) throws IOException {

//分多少块
		File src = new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java");
//		总长度
		long len = src.length();
//		每块大小
		int blockSize = 1024;
//		多少块
		int size = (int) Math.ceil(len * 1.0 / blockSize);
		System.out.println(size);
//		起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);

		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
//				最后一块
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println(i+"-->"+beginPos + "-->"+actualSize);
			split(i,beginPos,actualSize);
		}

	}

	public static void split(int i , int beginPos ,int actualSize) throws IOException {
		// 指定第i块的  ： 起始位置 + 实际大小
		RandomAccessFile raf = new RandomAccessFile(
				new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java"), "r");


		raf.seek(beginPos);

		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {

			if (actualSize > len) { // 获取本次读的所有内容
				System.out.println(new String(flush, 0, len));
				actualSize -= len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}

		}
	}

	public static void test_1() throws IOException {
		// 指定起始位置，读取剩余所有内容

		RandomAccessFile raf = new RandomAccessFile(
				new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java"), "r");

		// 随机读取
		raf.seek(2);

		// 操作
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}

		raf.close();

	}
}