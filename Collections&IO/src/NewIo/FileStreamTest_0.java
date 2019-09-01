package NewIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 文件输入输出流
 * 1. 源 2. 流 3. 操作 4.释放资源close
 * 
 * @author Ice
 *
 */
public class FileStreamTest_0 {
	
	public static void copyFile(String src, String des) {
		
		//1.源
	//	File src = new File("a.txt");
		FileInputStream is =null;
		//File des=new File("b.txt");
		FileOutputStream os =null;
		
		//2.文件流
		try {
			is= new FileInputStream(src);
			os = new FileOutputStream(des);
			//3。操作
			byte[] flush = new byte[1024]; //缓冲区
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
	