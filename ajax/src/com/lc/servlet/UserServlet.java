package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lc.service.UserService;
import com.lc.service.impl.UserServiceImpl;
import com.lc.vo.User;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8021907009163688155L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;character=utd-8");
		//获取请求信息
		String name =req.getParameter("name");
		System.out.println("用户请求信息为"+name);
		
		//处理请求信息
		
			//获取
			UserService us = new UserServiceImpl(); 
			User u =us.getUserInfoService(name);
			System.out.println("查询结果为"+u);
		//响应处理结果
			resp.getWriter().write(new Gson().toJson(u));
	}
}
