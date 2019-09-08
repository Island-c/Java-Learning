package com.l.chat_qunliao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �����ң�������
 * Ŀ�꣺Ⱥ��
 * @author Ice
 *
 */
public class Server {
	
	private static  CopyOnWriteArrayList<Channel> all =new CopyOnWriteArrayList<Channel>(); 
	public static void main(String[] args) throws IOException {
		 //1��ʹ��serversocket����������
		System.out.println("����������");
		ServerSocket server = new ServerSocket(8888);
		 //* 2. ����ʽ�ȴ����� accept
		 while(true) {
			 Socket client = server.accept();
			
			 Channel c = new Channel(client);
			 all.add(c); //�������г�Ա
			 new Thread(c).start();
			
		 }
		

	}
	
	static class Channel implements Runnable{
		//ÿ���ͻ���һ��Channel
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
				
				name = receive();//��ȡ����
				send_others(name+"������",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				release();
				System.out.println("����������");
			}
		}
		
		//������Ϣ
		private String receive() {
			String msg="";
			try {
				msg =dis.readUTF();
			}catch(IOException e) {
				System.out.println("���մ���");
				release();
			}

			return msg;
		}
		
		
		/**
		 * ˽��  ��ʽ ��  @xxx��msg
		 * @param msg
		 * @param flag
		 */
		private void send_others(String msg,boolean flag) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate) {
				//˽��
				int idx = msg.indexOf(":");
				//��ȡĿ�������
				try{
					String targetName = msg.substring(1,idx); //����ҿ�
					msg = msg.substring(idx+1);
					for(Channel other : all) {
						if(other.name.equals(targetName)) {
							other.send(this.name + "���ĵض���˵" + msg);
						}
					}
				}catch(Exception e) {
					System.out.println("��ʽ����");
				}
				
				
			}else {
				//Ⱥ��
				for(Channel other :all) {
					if(other == this){
						continue; 
					}
					if(!flag)
						other.send(this.name + "��������˵ �� "+msg);
					else {
						other.send(":"+msg);
					}
				}
			}

		}
		//������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("���ʹ���");
				release();
			}
			
		}
		
		//�ͷ���Դ
		private void release() {
			this.isRunning=false;
			Utils.close(dis,dos,client);
			all.remove(this);
			send_others(this.name + "�뿪��������",true);
		}
	}

}


