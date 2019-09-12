package com.lc.server.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	// 正文
	StringBuilder content;
	// 协议头信息
	private StringBuilder headInfo;
	private int len = 0;// 正文字节数

	private final String BLANK = " ";
	private final String CRLF = "\r\n";

	private Response() {
		content = new StringBuilder();
		headInfo = new StringBuilder();
		len = 0;
	}

	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			headInfo = null;
		}
	}

	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));

	}

	// add content dynamically
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;

	}

	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info + CRLF).getBytes().length;
		return this;
	}

	// build head info
	private void createHeadInfo(int code) {
//		1. HTTP/1.1 200
		headInfo.append("HTTP/1.1").append(BLANK);
		headInfo.append(code).append(BLANK);
		switch (code) {

		case 200:
			headInfo.append("OK").append(CRLF);
			break;
		case 404:
			headInfo.append("NOT FOUND").append(CRLF);
			break;
		case 505:
			headInfo.append("SERVER ERROR").append(CRLF);
			break;
		}

//		2. response line
		headInfo.append("Data:").append(new Date()).append(CRLF);
		headInfo.append("Server:").append("LC Server/0.0.1").append(CRLF);
		headInfo.append("Content-type:text/html;charset=utf-8").append(CRLF);
		headInfo.append("Content-length:").append(len).append(CRLF);
		headInfo.append(CRLF);

	}

	// push information
	public void pushToBrower(int code) throws IOException {

		createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
		
	}

}
