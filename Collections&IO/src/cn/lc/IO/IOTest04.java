package cn.lc.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * ͼƬ -> �ֽ�����
 * �ֽ�����-> �ļ�
 * @author Trail
 *
 */
public class IOTest04 {
	public static void main(String[] args)
	{
		byte[] a =fileToByteArray("a.jpeg");
		System.out.println(a.length);
		byteArrayToArray(a, "a_byte.jpg");
	}
	
	
	public static byte[] fileToByteArray(String filePath)
	{
		/*
		 * ͼƬ��ȡ���ֽ�����
		 * 1.ͼƬ������ FileInputStream
		 * 2.�����ֽ����� ByteArrayOutputStream
		 */
		File src=new File(filePath);
		byte[] dest=null;
		
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();
			
			byte[] flush = new byte[1024*10];
			int len=-1;
			while((len=is.read(flush))!=-1)
			{
				//д�����ֽ�������
				baos.write(flush,0,len);
			}
			baos.flush();
			dest=baos.toByteArray();
			return  dest;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				if(is!= null)
					is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	
	public static void byteArrayToArray(byte[] src, String filePath)
	{
		/**
		 * �ֽ�����д����ͼƬ
		 * 1.�ֽ����鵽���� ByteArrayInputStream
		 * 2.�����ļ� FileOutputStream
		 */
		File dest= new File(filePath);
		InputStream is=null;
		OutputStream os =null;
		try {
			is=new ByteArrayInputStream(src);
			os=new FileOutputStream(dest);
			
			byte[] flush = new byte[5];
			int len=-1;
			while((len=is.read(flush))!=-1)
			{
				os.write(flush, 0, len);
			}
			os.flush();
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
		
			e.printStackTrace();
		}finally {
			
			try {
				if(os != null)
					os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
