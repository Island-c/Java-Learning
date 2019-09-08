package com.l.chat_duoxiancheng;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室：服务器
 * 目标：实现多个客户收发消息
 * @author Ice
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		 //1。使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		 //* 2. 阻塞式等待连接 accept
		 while(true) {
			 Socket client = server.accept();
			 new Thread(()->{	
				System.out.println("一个客户端建立了连接");
				boolean isRunning =true;
				try {
				DataInputStream dis=new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				while(isRunning) {
					//3.接收消息
					
					String data = dis.readUTF();
					System.out.println(data);
					//4. 返回消息
					dos.writeUTF(data);
					dos.flush();
					
				}

				//5  释放资源
				dos .close();
				dis.close();
				client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					isRunning=false;
				}
				
			 }) .start();
			
		 }
		

	}

}


