package com.l.char_oop;

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
		System.out.println("服务器启动");
		ServerSocket server = new ServerSocket(8888);
		 //* 2. 阻塞式等待连接 accept
		 while(true) {
			 Socket client = server.accept();
			 System.out.println("一个客户端建立了连接"); 
			 new Thread(new Channel(client)).start();
			
		 }
		

	}
	
	static class Channel implements Runnable{
		//每个客户是一个Channel
		private DataInputStream dis =null;
		private DataOutputStream dos = null;
		private Socket client = null;
		private boolean isRunning;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				String msg=receive();
				if(!msg.equals("")) {
					send(msg);
				}
			}
		}
		
		public Channel(Socket client) {
			this.client =client;
			try {
				dis=new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				isRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				release();
				System.out.println("建立流错误");
			}
		}
		
		//接收消息
		private String receive() {
			String msg="";
			try {
				msg =dis.readUTF();
				System.out.println(client.getPort()+"  :" +msg);
			}catch(IOException e) {
				System.out.println("接收错误");
				release();
			}

			return msg;
		}
		
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("发送错误");
				release();
			}
			
		}
		
		//释放资源
		private void release() {
			this.isRunning=false;
			Utils.close(dis,dos,client);
			
		}
	}

}


