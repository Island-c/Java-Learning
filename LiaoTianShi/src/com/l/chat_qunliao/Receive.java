package com.l.chat_qunliao;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �ͻ��˵Ľ���
 * @author Ice
 *
 */
public class Receive implements Runnable {
	private Socket client;
	private DataInputStream dis;
	private boolean isRunning;
	
	public Receive(Socket client) {
		this.client = client ;
		this.isRunning = true;
		try {
			this.
			 dis = new DataInputStream(client .getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("����������");
			this.release();
		}
	}
	
	private String receive() {
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("���մ���");
			this.release();
		}
		return msg;
	}
	
	private void release() {
		this.isRunning = false;
		Utils.close(dis,client);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning ) {
			String msg=receive();
			if(!msg.equals(""))
				System.out.println(msg);
		}
	}
}
