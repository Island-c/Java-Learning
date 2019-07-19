package cn.lc.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流： InputStreamReader, OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本
 * 2.指定字符集
 * @author Trail
 *
 */
public class ConvertTest2 {

	public static void main(String[] args) {
		//操作 System.in System.out
		//InputStreamReader isr = new InputStreamReader(System.in);
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));)
		{
			//循环获取键盘输入 exit退出
			String msg="";
			while ( !msg.equals("exit") ) {
				msg=reader.readLine();
				writer.write(msg);
				writer.newLine();//新行
				writer.flush();//强制刷新
			}
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
		
		
		
		
	}
}
