package com.lc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.pojo.Flower;
import com.lc.service.FlowerService;
import com.lc.service.impl.FlowerServiceImpl;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
	private FlowerService flowerService = new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<Flower> list = flowerService.show();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
}
