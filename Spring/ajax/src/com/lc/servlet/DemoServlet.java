package com.lc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.pojo.Users;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		System.out.println("执行控制器");
		
		
		Users users1 = new Users(1,"李四","123456");
		Users users2 = new Users(2,"李四12","123451236");
		List<Users> list = new ArrayList<Users>();
		list.add(users1);
		list.add(users2);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		
		PrintWriter out = resp.getWriter();
		out.println(result) ;
		out.flush();
		out.close();
	}

}
