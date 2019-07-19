package cn.lc.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * IO Stream 测试
 * @author liu01
 *
 */
public class IOtest {

	public static void main(String []args)
	{
		//1.源
		File src = new File("b.txt");
		//2。流
		OutputStream os=null;
		try {
			os=new FileOutputStream(src,true); //true 末尾追加
			//3 操作
			String msg="IO is so easy";
			byte[] datas=msg.getBytes(); // 字符串->字节数组（编码）
			os.write(datas, 0, datas.length);
			os.flush(); //刷新
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
				if(null != os)
					os.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
