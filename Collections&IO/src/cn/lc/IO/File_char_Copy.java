package cn.lc.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class File_char_Copy {
	public static void main(String[] args) throws IOException {
		Reader read= new FileReader(new File("a.txt"));
		Writer write = new FileWriter(new File("c.txt"),false);
		
		char[] flush = new char[1024*10];
		
		int len=0;
		
		while ((len=read.read(flush))!=-1) {
			String str= new String(flush ,0,len);
			write.write(str.toCharArray());
			write.write(str);
			write.append("77777777777");
			System.out.println(str);
		}
		
		
		
		write.close();
		read.close();
	}
}
