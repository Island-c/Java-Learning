package NewIo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * ��װ�ָ�
 * 
 * @author Ice
 *
 */


public class SplitFile {

//		Դͷ 
	private File src;
//		Ŀ�ĵ�
	private String destDir;
//		�ָ���ļ��д洢·��
	private List<String> destPaths;
//		ÿ���С
	private int blockSize;
//		����
	private int size;

	public SplitFile(String srcPath, String destDirs, int blockSize) {
		this.src = new File(srcPath);
		this.destDir = destDirs;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
//		��ʼ��
		init();
	}

	private void init() {
//		�ܳ���
		long len = this.src.length();
//		���ٿ�
		this.size = (int) Math.ceil(len * 1.0 / this.blockSize);
		
//		·��
		for(int i= 0 ;i<size ; i++) {
			System.out.println(this.destDir+i+"-"+this.src.getName());
			this.destPaths.add(this.destDir+i+"-"+this.src.getName());														
		}
	}

	public void split() throws IOException {
//		�ܳ���
		long len = this.src.length();
//				��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);

		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
//						���һ��
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println(i+"-->"+beginPos + "-->"+actualSize);
			splitDetail(i,beginPos,actualSize);
		}
	}
//	�ָ ����ÿһ�����ʼλ�úʹ�С
	public void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		// ָ����i��� �� ��ʼλ�� + ʵ�ʴ�С
		RandomAccessFile raf = new RandomAccessFile(new File("a.jpeg"), "r");
		RandomAccessFile raf_2 = new RandomAccessFile(new File(this.destPaths.get(i)), "rw");
		raf.seek(beginPos);

		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush))  != -1) {

			if (actualSize > len) { // ��ȡ���ζ�����������
				System.out.println(new String(flush, 0, len));
				raf_2.write(flush, 0, len);
				actualSize -= len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				raf_2.write(flush, 0, len);
				break;
			}

		}
		raf_2.close();
		raf.close();
	}

	public void merge(String destPath) throws IOException
	{
//		�����
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream> vi =new Vector<InputStream>();
		SequenceInputStream sis =null;

//		������
		for(int i=0;i<destPaths.size(); i++) {
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i)))) ;//�ֱ���ÿ���ָ���ļ��������������ζ���
		}
		sis =  new SequenceInputStream(vi.elements());
//			����
		byte[] flush =new byte[1024];
		int len=-1;
		while ((len=sis.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		os.flush();
		sis.close();
		
		os.close();
	}
	
	public static void main(String[] args) {
		SplitFile sf = new SplitFile("a.jpeg","d",1024*10);
		try {
			sf.split();
			sf.merge("ccc.jpeg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
