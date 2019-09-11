package cn.lc.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流： InputStreamReader 和 OutputStreamWriter
 * 1.以字符流的形式操作字节流 （纯文本）
 * 2. 指定字符集
 * @author Ice
 *
 */
public class InputStreamReaderTest {
	public static void main(String[] args) {
		//操作System.in 和 System.out
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
			//循环获取键盘输入，输出内容 （exit退出
			String msg = "";
			while(!msg .equals("exit")) {
				msg=reader.readLine();
				writer.write(msg);//循环写出
				writer.newLine();
				writer.flush();
			}
		}catch (IOException e ){
			System.out.println("操作异常");
		}
		
		
		
	}
}
