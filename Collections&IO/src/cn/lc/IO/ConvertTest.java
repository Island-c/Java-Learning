package cn.lc.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ת������ InputStreamReader, OutputStreamWriter
 * 1.���ַ�������ʽ�����ֽ��������ı�
 * 2.ָ���ַ���
 * @author Trail
 *
 */
public class ConvertTest {
	public static void main(String[] args) {
		try(BufferedReader reader = 
				new BufferedReader (//����
						new InputStreamReader( //�ַ����������룩
								new URL("http://www.baidu.com").openStream(),"UTF-8"));)//�ֽ�
		{
			 String temp;
			 while((temp = reader.readLine())!=null){
				 System.out.print(temp);
			 }
			
		
			
		}catch(IOException e) {
			System.out.println("�����쳣");
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
			System.out.println("�����쳣");
		}
			
	}
	
	
	public static void test1(String[] args) {
		//���� System.in System.out
		//InputStreamReader isr = new InputStreamReader(System.in);
		try(InputStream is = new URL("http://www.baidu.com").openStream();)
		{
			 int temp;
			 while((temp = is.read())!=-1){
				 System.out.print((char)temp);
			 }
			
		
			
		}catch(IOException e) {
			System.out.println("�����쳣");
		}
		
		
		
		
		
	}
}
