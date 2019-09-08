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

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		DataInputStream dis = new DataInputStream(client .getInputStream());
		
		//2 。 客户端发送消息
		boolean isRunning = true;
		while(isRunning) {
			String msg=console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			//3. 获取消息
			msg = dis.readUTF();
			System.out.println(msg);
		}


		
		//4. 释放资源
		dos .close();
		dis.close();
		client.close();
	}
}
