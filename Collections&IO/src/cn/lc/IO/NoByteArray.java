package cn.lc.IO;
/**
 * 不使用字节流。。。也可以导入导出图片，write时需要制定offset和length ， 不然会输出整个缓存
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NoByteArray {
	public static void main(String[] args) {
		BufferedInputStream is_1=null;
		BufferedOutputStream os_1=null;
		try {
			is_1 = new BufferedInputStream(new FileInputStream(new File("a.jpeg")));
			os_1 =new BufferedOutputStream( new FileOutputStream(new File("b.jpeg")));
			byte[] flush = new byte[1024*600];
			int len=0;
			while((len=is_1.read(flush))!=-1) {
				os_1.write(flush,0,len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null != is_1)
			{
				try {
					is_1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != os_1) {
				try {
					os_1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
