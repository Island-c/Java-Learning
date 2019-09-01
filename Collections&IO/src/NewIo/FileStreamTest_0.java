package NewIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * �ļ����������
 * 1. Դ 2. �� 3. ���� 4.�ͷ���Դclose
 * 
 * @author Ice
 *
 */
public class FileStreamTest_0 {
	
	public static void copyFile(String src, String des) {
		
		//1.Դ
	//	File src = new File("a.txt");
		FileInputStream is =null;
		//File des=new File("b.txt");
		FileOutputStream os =null;
		
		//2.�ļ���
		try {
			is= new FileInputStream(src);
			os = new FileOutputStream(des);
			//3������
			byte[] flush = new byte[1024]; //������
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush);
			//	System.out.println(len);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( null != is ) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
	