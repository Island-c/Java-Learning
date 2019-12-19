package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.pojo.Flower;
import com.lc.service.FlowerService;
import com.lc.service.impl.FlowerServiceImpl;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet{

	private FlowerService flowerService = new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String name =req.getParameter("name");
		String price = req.getParameter("price");
		String production =req.getParameter("production");
		
		int index = flowerService.add(new Flower(0,name,Double.parseDouble(price),production));
		if(index>0) {
			resp.sendRedirect("show");
		}else {
			resp.sendRedirect("add.jsp");
		}
		
		
	}
	
}
