package cn.lc.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ����������д�� ���ȡ
 * ��ȡ��˳���д��˳��һ��
 * @author Ice
 *
 */
public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		//д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //��������ù�
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos)); //������д����baos����
		//������������+����
		dos.writeUTF("������");
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas =baos.toByteArray();
		//��ȡ
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		boolean flag = dis.readBoolean();
		char ch= dis.readChar();
		System.out.println(msg);
	}
}
