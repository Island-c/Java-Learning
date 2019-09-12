package com.lc.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *多线程
 * 
 * @author Ice
 *
 */
public class Server {

	private ServerSocket serverSocket;
	private boolean isRunning;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();

	}

	// 开始
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			this.isRunning=true;
			receive();
		} catch (IOException e) {
			System.out.println("服务器启动失败....");
			stop();
		}
	}
	//结束
	public void stop() {
		try {
			isRunning=false;
			this.serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 接收
	public void receive() {
		while(isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接....");
				
				new Thread(new Dispatcher(client)).start();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端结束");
			}
		}


	}


}
