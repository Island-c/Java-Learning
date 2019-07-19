package cn.lc.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedTest01 {
	public static void main(String[] args) {

		//1.Ô´
		File src = new File("a.txt");
		//2¡£Á÷
		InputStream is =null;
		//BufferedInputStream bis = null;
		try {
			
			is = new BufferedInputStream(new FileInputStream(src));
			
			byte[] flush = new byte[1024];
			int len= -1;
			while((len=is.read(flush))!=-1) {
				String str = new String(flush,0,len);
				System.out.println(str);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
				if(null != is)
					is.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(null!=is)
					is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		File dest= new File("a_copy.txt");
		
		OutputStream os = null;
		
		try {
			os=new BufferedOutputStream(new FileOutputStream(dest));	
			String msg ="io is hard\r\n";
			byte[] datas=msg.getBytes();
			
			os.write(datas, 0, datas.length);
			os.flush();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if((null != os))
					os.close();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		
		}
		
	}
	

}
