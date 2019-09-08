package com.l.char3_Manypeople;

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
public class Chat {
	public static void main(String[] args) throws IOException {
		 //1。使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		Socket client=null;
		 //* 2. 阻塞式等待连接 accept
		boolean isRun=true;
		while(isRun) {
			client = server.accept();
			System.out.println("一个客户端建立了连接");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());

			
			boolean isRunning =true;
			while(isRunning) {
				//3.接收消息
				
				String data = dis.readUTF();
				if (data .equals("quite"))
					isRunning=false;
				System.out.println(data);
				//4. 返回消息
				dos.writeUTF(data);
				dos.flush();
				
			}

			//5  释放资源
			dos .close();
			dis.close();
			
		}
		client.close();

	}

}
