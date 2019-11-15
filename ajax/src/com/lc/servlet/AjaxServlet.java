package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//web3.0使用注解替代配置xml文件
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String name = req.getParameter("name");
		String pwd= req.getParameter("pwd");
		System.out.println(name+":"+pwd+":"+req.getMethod());
		//处理请求信息
		//响应处理结果
		resp.getWriter().write("雾霾真大");
		
	}	
}
