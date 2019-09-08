package com.l.chat_duoxiancheng;

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
		ServerSocket server = new ServerSocket(8888);
		 //* 2. ����ʽ�ȴ����� accept
		 while(true) {
			 Socket client = server.accept();
			 new Thread(()->{	
				System.out.println("һ���ͻ��˽���������");
				boolean isRunning =true;
				try {
				DataInputStream dis=new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				while(isRunning) {
					//3.������Ϣ
					
					String data = dis.readUTF();
					System.out.println(data);
					//4. ������Ϣ
					dos.writeUTF(data);
					dos.flush();
					
				}

				//5  �ͷ���Դ
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


