package com.l.char3_Manypeople;

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
public class Chat {
	public static void main(String[] args) throws IOException {
		 //1��ʹ��serversocket����������
		ServerSocket server = new ServerSocket(8888);
		Socket client=null;
		 //* 2. ����ʽ�ȴ����� accept
		boolean isRun=true;
		while(isRun) {
			client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());

			
			boolean isRunning =true;
			while(isRunning) {
				//3.������Ϣ
				
				String data = dis.readUTF();
				if (data .equals("quite"))
					isRunning=false;
				System.out.println(data);
				//4. ������Ϣ
				dos.writeUTF(data);
				dos.flush();
				
			}

			//5  �ͷ���Դ
			dos .close();
			dis.close();
			
		}
		client.close();

	}

}
