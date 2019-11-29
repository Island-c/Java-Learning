package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.service.LogService;
import com.lc.service.impl.LogServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {

	private LogService logservice = new LogServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		int pageSize =2;
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize= Integer.parseInt(pageSizeStr);
		}
		
		int pageNumber = 1;
		String pageNumberStr=req.getParameter("pageNumber");
		if(pageNumberStr != null && !"".equals(pageNumberStr)) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		req.setAttribute("pageinfo", logservice.showPage(pageSize, pageNumber));
		
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
		
	}
}
