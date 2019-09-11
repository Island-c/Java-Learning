package com.lc.commonsIOTest;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class CIOTest02 {
	public static void main(String[] args) {
		Collection<File> files = FileUtils.listFiles(new File("D:\\学习视频\\300\\01.JAVA\\08_IO流技术"),
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

		System.out.println("-------------------------------");
		files = FileUtils.listFiles(new File("D:\\学习视频\\300\\01.JAVA\\08_IO流技术"), EmptyFileFilter.NOT_EMPTY,
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}

		System.out.println("---------------------------------");
		files = FileUtils.listFiles(new File("D:\\\\学习视频\\\\300\\\\01.JAVA\\\\08_IO流技术"),
				FileFilterUtils.or(new SuffixFileFilter("java"),EmptyFileFilter.EMPTY,new SuffixFileFilter("rar")), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
