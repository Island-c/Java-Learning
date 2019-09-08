package com.l.char_oop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����ң�������
 * Ŀ�꣺ʵ�ֶ���ͻ��շ���Ϣ
 * @author Ice
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		 //1��ʹ��serversocket����������
		System.out.println("����������");
		ServerSocket server = new ServerSocket(8888);
		 //* 2. ����ʽ�ȴ����� accept
		 while(true) {
			 Socket client = server.accept();
			 System.out.println("һ���ͻ��˽���������"); 
			 new Thread(new Channel(client)).start();
			
		 }
		

	}
	
	static class Channel implements Runnable{
		//ÿ���ͻ���һ��Channel
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
				System.out.println("����������");
			}
		}
		
		//������Ϣ
		private String receive() {
			String msg="";
			try {
				msg =dis.readUTF();
				System.out.println(client.getPort()+"  :" +msg);
			}catch(IOException e) {
				System.out.println("���մ���");
				release();
			}

			return msg;
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
			
		}
	}

}


