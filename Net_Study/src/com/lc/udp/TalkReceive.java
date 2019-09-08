package com.lc.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端:使用面向对象封装
 * @author Ice
 *
 */
public class TalkReceive implements Runnable {
	private DatagramSocket server;

	private String toIp;
	private int toPort;
	private String from;
	public TalkReceive(int port,String from) {
		this.from = from;
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			// * 2. 准备容器，封装成DatagramPacket
			byte[] container = new byte[1024*60]; //60k
			DatagramPacket packet = new DatagramPacket(container, 0 ,container.length);
			// * 3. 阻塞式接收包裹 receive(DatagramPacket p)
			try {
				server.receive(packet); //阻塞式
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//  4. 分析数据
			byte[] datas = packet.getData();
			int len = packet.getLength(); //包的实际长度
			String data=new String(datas,0,len);
			System.out.println(from+": "+data);
			
			if(data.equals("bye"))
				break;
		}
		 //* 5.释放资源
		server.close();
	}
}
