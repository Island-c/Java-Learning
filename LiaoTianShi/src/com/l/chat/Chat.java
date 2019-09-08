package com.l.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�������
 * Ŀ�꣺ʵ��һ���ͻ��շ���Ϣ
 * @author Ice
 *
 */
public class Chat {
	public static void main(String[] args) throws IOException {
		 //1��ʹ��serversocket����������
		ServerSocket server = new ServerSocket(8888);
		 
		 //* 2. ����ʽ�ȴ����� accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		
		//3.������Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		
		//4. ������Ϣ
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(data);
		dos.flush();
		
		//5  �ͷ���Դ
		dos .close();
		dis.close();
		client.close();

	}
}
