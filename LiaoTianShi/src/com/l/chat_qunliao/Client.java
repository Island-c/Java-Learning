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
 *  聊天室
 *  客户端
 * @author Ice
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Client!!");
		 //* 1. 建立连接：使用Socket创建客户端 + 服务器的地址和端口
		Socket client = new Socket ("localhost",8888);
		new Thread(new Receive(client)).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String usr_name = br.readLine();

		new Thread(new Send(client,usr_name)).start();
	}
}
