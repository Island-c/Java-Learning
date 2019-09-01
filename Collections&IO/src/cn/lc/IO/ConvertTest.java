package cn.lc.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 转换流： InputStreamReader, OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本
 * 2.指定字符集
 * @author Trail
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
		try(BufferedReader reader = 
				new BufferedReader (//缓冲
						new InputStreamReader( //字符（避免乱码）
								new URL("http://www.baidu.com").openStream(),"UTF-8"));)//字节
		{
			 String temp;
			 while((temp = reader.readLine())!=null){
				 System.out.print(temp);
			 }
			
		
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
	}
	public static void test2(String[] args) {
		try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");)
		{
			 int temp;
			 while((temp = is.read())!=-1){
				 System.out.print((char)temp);
			 }
			
		
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
			
	}
	
	
	public static void test1(String[] args) {
		//操作 System.in System.out
		//InputStreamReader isr = new InputStreamReader(System.in);
		try(InputStream is = new URL("http://www.baidu.com").openStream();)
		{
			 int temp;
			 while((temp = is.read())!=-1){
				 System.out.print((char)temp);
			 }
			
		
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
		
		
		
		
	}
}
