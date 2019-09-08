package com.lc.udp;
/**
 * 多线程，双向交流，在线咨询
 * @author Ice
 *
 */
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(5555,"localhost",9999)).start(); //发送
		new Thread(new TalkReceive(8888,"Teacher")).start();
	}
}
