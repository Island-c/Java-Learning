package com.l.multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�������
 * Ŀ�꣺ʵ���շ�������Ϣ
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
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());

		
		boolean isRunning =true;
		while(isRunning) {
			//3.������Ϣ
			
			String data = dis.readUTF();
			System.out.println(data);
			//4. ������Ϣ
			dos.writeUTF(data);
			dos.flush();
			
		}

		//5  �ͷ���Դ
		dos .close();
		dis.close();
		client.close();

	}
}
