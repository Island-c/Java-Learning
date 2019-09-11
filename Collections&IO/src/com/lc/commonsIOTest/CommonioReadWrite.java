package com.lc.commonsIOTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class CommonioReadWrite {
	public static void main(String[] args) throws IOException {
		//�����ļ�
		FileUtils.copyFile(new File("a.jpeg"),new File( "c.jpeg"));
		//�����ļ���Ŀ¼
		FileUtils.copyFileToDirectory(new File("a.jpeg"), new File("lib"));
		//����Ŀ¼��Ŀ¼
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib_copy"));
		//����Ŀ¼ 
		FileUtils.copyDirectory(new File("lib"),new File("lib2/lib"));
		//����URL����
		String url="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1568103325&di=7653a7c544fd6f0c25fddc8f3f597e37&src=http://img008.hc360.cn/m7/M03/5F/A1/wKhQpFYose2EPo2jAAAAANgFb9Y411.jpg";
		FileUtils.copyURLToFile(new URL(url), new File("a.jpeg"));
		
		String datas = IOUtils.toString(new URL("http://www.163.com"),"GBK");
		System.out.println(datas);
	}

	public static void write() throws IOException{
//		д���ļ�
		FileUtils.write(new File("b.txt"), "ѧϰʹ�ҿ���\n", "GBK", true);

		FileUtils.writeStringToFile(new File("b.txt"), "ѧϰʹ�ҿ���\n", "GBK", true);

		FileUtils.writeByteArrayToFile(new File("b.txt"), "ѧϰʹ�ҿ���\n".getBytes("GBK"), true);

//		д���б�
		List<String> datas = new ArrayList<String>();
		datas.add("��1");
		datas.add("��2");
		datas.add("��3");
		FileUtils.writeLines(new File("b.txt"), datas, "---------", true);
		
	}
	public static void read() throws IOException {
//		��ȡ�ļ�
		String msg = FileUtils.readFileToString(new File("a.txt"), "GBK");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("a.txt"));
		System.out.println(datas.length);
//		���ж�ȡ	
		List<String> msgs = FileUtils.readLines(new File("a.txt"), "GBK");
		for (String str : msgs) {
			System.out.println(str);
		}

		LineIterator it = FileUtils.lineIterator(new File("a.txt"), "GBK");
		while (it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}
}
