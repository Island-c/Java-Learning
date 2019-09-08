package com.lc.udp;
/***
     *  多线程，双向交流，在线咨询
 * @author Ice
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"student")).start();
		new Thread(new TalkSend(5556,"localhost",8888)).start(); //发送
	}
}
