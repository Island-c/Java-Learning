package com.lc.commonsIOTest;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOTest01 {
	public static void main(String[] args) {
		// �ļ���С
		long len = FileUtils.sizeOf(new File("a.jpeg"));
		System.out.println(len);
		// Ŀ¼��С
		len = FileUtils.sizeOf(new File("D:\\ѧϰ��Ƶ\\300\\01.JAVA\\08_IO������"));

		System.out.println(len);

	}
}
