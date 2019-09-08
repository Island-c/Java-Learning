package com.l.char_oop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端的发送
 * @author Ice
 *
 */
public class Send implements Runnable {
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	public Send(Socket client) {
		this.client = client;
		this.isRunning=true;
		console = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("创建流错误");
			this.release();
		}
	}
	
	//释放资源
	private void release() {
		this.isRunning=false;
		Utils.close(dos,client);
		
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
	
	private String getStrFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg =getStrFromConsole();
			if(!msg.equals("")){
				send(msg);
			}
			
			
		}
	}
}
