package com.lc.udp;
/**
 * ���̣߳�˫������������ѯ
 * @author Ice
 *
 */
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(5555,"localhost",9999)).start(); //����
		new Thread(new TalkReceive(8888,"Teacher")).start();
	}
}
