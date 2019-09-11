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
		//复制文件
		FileUtils.copyFile(new File("a.jpeg"),new File( "c.jpeg"));
		//复制文件到目录
		FileUtils.copyFileToDirectory(new File("a.jpeg"), new File("lib"));
		//复制目录到目录
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib_copy"));
		//复制目录 
		FileUtils.copyDirectory(new File("lib"),new File("lib2/lib"));
		//拷贝URL内容
		String url="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1568103325&di=7653a7c544fd6f0c25fddc8f3f597e37&src=http://img008.hc360.cn/m7/M03/5F/A1/wKhQpFYose2EPo2jAAAAANgFb9Y411.jpg";
		FileUtils.copyURLToFile(new URL(url), new File("a.jpeg"));
		
		String datas = IOUtils.toString(new URL("http://www.163.com"),"GBK");
		System.out.println(datas);
	}

	public static void write() throws IOException{
//		写出文件
		FileUtils.write(new File("b.txt"), "学习使我快乐\n", "GBK", true);

		FileUtils.writeStringToFile(new File("b.txt"), "学习使我快乐\n", "GBK", true);

		FileUtils.writeByteArrayToFile(new File("b.txt"), "学习使我快乐\n".getBytes("GBK"), true);

//		写出列表
		List<String> datas = new ArrayList<String>();
		datas.add("马1");
		datas.add("马2");
		datas.add("马3");
		FileUtils.writeLines(new File("b.txt"), datas, "---------", true);
		
	}
	public static void read() throws IOException {
//		读取文件
		String msg = FileUtils.readFileToString(new File("a.txt"), "GBK");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("a.txt"));
		System.out.println(datas.length);
//		逐行读取	
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
