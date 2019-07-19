package cn.lc.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 使用字节输入流输出流实现文件拷贝
 * @author liu01
 *
 */
public class CopyFile {

	public static void main(String []args)
	{
		copy("a.jpeg","c.jpg");
	}
	
	public static void copy(String srcPath, String deatPath)
	{
		File src = new File (srcPath);
		File dest = new File (deatPath);
		
		InputStream is=null;
		OutputStream os=null;
		
		try {
			is=new FileInputStream (src);
			os=new FileOutputStream(dest,true);
			
			byte[] flush = new byte[1024*10]; 
			int len=-1;
			while((len=is.read(flush))!=-1)
			{
				String str=new String(flush,0,len);
				//System.out.println(str);
				os.write(flush, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源，先打开的后关闭
			try {
				if(os!=null) {
					os.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(is != null) {
					is.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}

		}	
	}
}
