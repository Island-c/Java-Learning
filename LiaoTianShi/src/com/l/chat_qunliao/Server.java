package com.l.chat_qunliao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 聊天室：服务器
 * 目标：群聊
 * @author Ice
 *
 */
public class Server {
	
	private static  CopyOnWriteArrayList<Channel> all =new CopyOnWriteArrayList<Channel>(); 
	public static void main(String[] args) throws IOException {
		 //1。使用serversocket创建服务器
		System.out.println("服务器启动");
		ServerSocket server = new ServerSocket(8888);
		 //* 2. 阻塞式等待连接 accept
		 while(true) {
			 Socket client = server.accept();
			
			 Channel c = new Channel(client);
			 all.add(c); //管理所有成员
			 new Thread(c).start();
			
		 }
		

	}
	
	static class Channel implements Runnable{
		//每个客户是一个Channel
		private DataInputStream dis =null;
		private DataOutputStream dos = null;
		private Socket client = null;
		private boolean isRunning;
		private String name;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				String msg=receive();
				if(!msg.equals("")) {
					//send(msg);
					send_others(msg,false);
				}
			}
		}
		
		public Channel(Socket client) {
			this.client =client;
			try {
				dis=new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				isRunning=true;
				
				name = receive();//获取名称
				send_others(name+"已上线",true);
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
			}catch(IOException e) {
				System.out.println("接收错误");
				release();
			}

			return msg;
		}
		
		
		/**
		 * 私聊  格式 ：  @xxx：msg
		 * @param msg
		 * @param flag
		 */
		private void send_others(String msg,boolean flag) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate) {
				//私聊
				int idx = msg.indexOf(":");
				//获取目标和数据
				try{
					String targetName = msg.substring(1,idx); //左闭右开
					msg = msg.substring(idx+1);
					for(Channel other : all) {
						if(other.name.equals(targetName)) {
							other.send(this.name + "悄悄地对您说" + msg);
						}
					}
				}catch(Exception e) {
					System.out.println("格式错误");
				}
				
				
			}else {
				//群聊
				for(Channel other :all) {
					if(other == this){
						continue; 
					}
					if(!flag)
						other.send(this.name + "对所有人说 ： "+msg);
					else {
						other.send(":"+msg);
					}
				}
			}

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
			all.remove(this);
			send_others(this.name + "离开了聊天室",true);
		}
	}

}


