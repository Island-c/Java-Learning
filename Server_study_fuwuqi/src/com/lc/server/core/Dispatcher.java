package com.lc.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 * 分发器
 * 加入状态处理： 404 500 505   首页
 * @author Ice
 *
 */
public class Dispatcher implements Runnable {
	private Socket client;
	private Response response;
	private Request request;
	private Servlet servlet;
	public Dispatcher(Socket client) 
	{
		this.client =client;
		try {
			this.request = new Request(client);
			this.response = new Response(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.release();
		}
	}

	@Override
	public void run() {		
		
		try {
			if(null== request.getUrl() || request.getUrl().equals("")) {
				InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] flush = new byte[1024*10];
				int len =is.read(flush);
				response.print(new String (flush,0,len));
				response.pushToBrower(200);
				is.close();
				return ;
			}
			servlet = WebApp.getServletFromUrl(request.getUrl());

			if (null != servlet) {
				servlet.service(request, response);
				// code
				response.pushToBrower(200);
			}else {
				//error
				response.println("404 NOT FOUND");
				InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] flush = new byte[1024*10];
				int len =is.read(flush);
				response.pushToBrower(404);
				is.close();
			}
		}catch(Exception e) {
			try {
				response.pushToBrower(500);
				response.println("500 error");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		release();

		
	}
	
	private void release() {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
