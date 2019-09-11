package com.lc.commonsIOTest;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTest01 {
	public static void main(String[] args) {
		// 文件大小
		long len = FileUtils.sizeOf(new File("a.jpeg"));
		System.out.println(len);
		// 目录大小
		len = FileUtils.sizeOf(new File("D:\\学习视频\\300\\01.JAVA\\08_IO流技术"));

		System.out.println(len);

	}
}
