package cn.lc.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest03 {
	public static void main(String[] args)
	{
		/*字节数组输入*/
		byte[] src="talk is cheap show me the code".getBytes(); //转字节数组
		InputStream is =null;
		try {
			is=new ByteArrayInputStream(src);
			
			byte[] flush=new byte[5];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				String str=new String(flush);
				System.out.println(str);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally {
			//也可以不关闭
			try {
				if(is!=null)
					is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/*字节数组输出*/
		byte[] dest = null;
		ByteArrayOutputStream baos = null;
		try {
			baos=new ByteArrayOutputStream(); //不需要关联源
			String msg="show me your code";
			byte[]datas = msg.getBytes();
			baos.write(datas,0,datas.length);
			baos.flush();
			dest=baos.toByteArray(); //从缓冲区获取数据
			System.out.println(dest.length + "->>>" + new String(dest,0,baos.size()));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//也可以不关闭
			try {
				if(baos!=null)
					baos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
