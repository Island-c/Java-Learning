package com.l.chat_qunliao;

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
		new Thread(new Receive(client)).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���");
		String usr_name = br.readLine();

		new Thread(new Send(client,usr_name)).start();
	}
}
