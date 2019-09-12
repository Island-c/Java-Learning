package com.lc.user;

import com.lc.server.core.Request;
import com.lc.server.core.Response;
import com.lc.server.core.Servlet;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("<第一个servlet>");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("用户名：" + request.getParameter("uname"));
		response.print("密码：" + request.getParameter("pwd"));
		response.print("</body>");
		response.print("</html>");
	}
}
