package com.lc.user;

import com.lc.server.core.Request;
import com.lc.server.core.Response;
import com.lc.server.core.Servlet;

public class OthersServlet implements Servlet{
	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("其他测试页面");
		
		
	}
}
