package NewIo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {
	public static void main(String[] args) throws IOException {

//�ֶ��ٿ�
		File src = new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java");
//		�ܳ���
		long len = src.length();
//		ÿ���С
		int blockSize = 1024;
//		���ٿ�
		int size = (int) Math.ceil(len * 1.0 / blockSize);
		System.out.println(size);
//		��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);

		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
//				���һ��
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
		// ָ����i���  �� ��ʼλ�� + ʵ�ʴ�С
		RandomAccessFile raf = new RandomAccessFile(
				new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java"), "r");


		raf.seek(beginPos);

		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {

			if (actualSize > len) { // ��ȡ���ζ�����������
				System.out.println(new String(flush, 0, len));
				actualSize -= len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}

		}
	}

	public static void test_1() throws IOException {
		// ָ����ʼλ�ã���ȡʣ����������

		RandomAccessFile raf = new RandomAccessFile(
				new File("D:\\workspace\\Collections&IO\\src\\NewIo\\FilesCopy_2.java"), "r");

		// �����ȡ
		raf.seek(2);

		// ����
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}

		raf.close();

	}
}