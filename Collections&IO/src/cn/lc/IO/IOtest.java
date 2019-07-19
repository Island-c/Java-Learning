package cn.lc.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * IO Stream ����
 * @author liu01
 *
 */
public class IOtest {

	public static void main(String []args)
	{
		//1.Դ
		File src = new File("b.txt");
		//2����
		OutputStream os=null;
		try {
			os=new FileOutputStream(src,true); //true ĩβ׷��
			//3 ����
			String msg="IO is so easy";
			byte[] datas=msg.getBytes(); // �ַ���->�ֽ����飨���룩
			os.write(datas, 0, datas.length);
			os.flush(); //ˢ��
		
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
