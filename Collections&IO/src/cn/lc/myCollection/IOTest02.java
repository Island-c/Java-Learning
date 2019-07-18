package cn.lc.myCollection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * Reader Writer 测试
 * @author Trail
 *
 */
public class IOTest02 {
	public static void main(String[] args)
	{
		/*文件字符输入*/
		File src=new File("a.txt");	
		Reader reader=null;	
		try {
			reader = new FileReader(src);
			char[] flush = new char[2]; 
			int len=-1;
			while((len = reader.read(flush))!=-1) {
				 String str=new String(flush,0,len);
				 System.out.println(str);
			} 
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally {
			try {
				if(reader != null)
					reader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		/*文件字符输出*/
		File dest=new File("dest.txt");
		Writer write =null;
		
		try {
			write=new FileWriter(dest);
			String msg="你就是不相信我说的";
			char[] datas=msg.toCharArray();
			write.write(datas, 0, datas.length);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(write != null)
					write.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
