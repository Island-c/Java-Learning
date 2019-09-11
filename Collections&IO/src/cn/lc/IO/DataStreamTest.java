package cn.lc.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流：先写出 后读取
 * 读取的顺序和写出顺序一致
 * @author Ice
 *
 */
public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //这个流不用关
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos)); //把数据写到了baos流中
		//操作数据类型+数据
		dos.writeUTF("辛酸泪");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas =baos.toByteArray();
		//读取
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch= dis.readChar();
		System.out.println(msg);
	}
}
