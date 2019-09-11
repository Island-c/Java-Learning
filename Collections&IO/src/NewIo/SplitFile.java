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
 * 封装分割
 * 
 * @author Ice
 *
 */


public class SplitFile {

//		源头 
	private File src;
//		目的地
	private String destDir;
//		分割后文件夹存储路径
	private List<String> destPaths;
//		每块大小
	private int blockSize;
//		块数
	private int size;

	public SplitFile(String srcPath, String destDirs, int blockSize) {
		this.src = new File(srcPath);
		this.destDir = destDirs;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
//		初始化
		init();
	}

	private void init() {
//		总长度
		long len = this.src.length();
//		多少块
		this.size = (int) Math.ceil(len * 1.0 / this.blockSize);
		
//		路径
		for(int i= 0 ;i<size ; i++) {
			System.out.println(this.destDir+i+"-"+this.src.getName());
			this.destPaths.add(this.destDir+i+"-"+this.src.getName());														
		}
	}

	public void split() throws IOException {
//		总长度
		long len = this.src.length();
//				起始位置和实际大小
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);

		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
//						最后一块
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println(i+"-->"+beginPos + "-->"+actualSize);
			splitDetail(i,beginPos,actualSize);
		}
	}
//	分割： 计算每一块的起始位置和大小
	public void splitDetail(int i, int beginPos, int actualSize) throws IOException {
		// 指定第i块的 ： 起始位置 + 实际大小
		RandomAccessFile raf = new RandomAccessFile(new File("a.jpeg"), "r");
		RandomAccessFile raf_2 = new RandomAccessFile(new File(this.destPaths.get(i)), "rw");
		raf.seek(beginPos);

		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush))  != -1) {

			if (actualSize > len) { // 获取本次读的所有内容
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
//		输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream> vi =new Vector<InputStream>();
		SequenceInputStream sis =null;

//		输入流
		for(int i=0;i<destPaths.size(); i++) {
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i)))) ;//分别建立每个分割后文件的输入流，依次读入
		}
		sis =  new SequenceInputStream(vi.elements());
//			拷贝
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
