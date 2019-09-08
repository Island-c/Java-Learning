package com.l.multichat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  ������
 *  �ͻ���
 * @author Ice
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Client!!");
		 //* 1. �������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
		Socket client = new Socket ("localhost",8888);

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		DataInputStream dis = new DataInputStream(client .getInputStream());
		
		//2 �� �ͻ��˷�����Ϣ
		boolean isRunning = true;
		while(isRunning) {
			String msg=console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3. ��ȡ��Ϣ
			msg = dis.readUTF();
			System.out.println(msg);
		}


		
		//4. �ͷ���Դ
		dos .close();
		dis.close();
		client.close();
	}
}
