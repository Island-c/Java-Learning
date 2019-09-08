package com.lc.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端:使用面向对象封装
 * @author Ice
 *
 */
public class TalkSend implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIp;
	private int toPort;

	
	public TalkSend(int port,String toIp, int toPort) {
		this.toIp = toIp;
		this.toPort = toPort;

		try {
			client = new DatagramSocket(port);
			reader= new BufferedReader(new InputStreamReader(System.in));
		}catch(SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			String data=null;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				// * 3. 封装成DatagramPacket包裹，需要指定目的地
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length, new InetSocketAddress(this.toIp,this.toPort));
				// * 4. 发送包裹 send(DatagramPacket p)
				client.send(packet);
				if(data.equals("bye"))
					break;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		// * 5.释放资源
		client.close();

	}
}
