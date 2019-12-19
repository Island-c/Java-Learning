package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lc.service.AirportService;
import com.lc.service.impl.AirportServiceImpl;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet{

	private AirportService airportService;
	
	@Override
	public void init() throws ServletException {
		//对service实例化
		//spring和web整合后所有信息都存放在webApplicationContext中
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		airportService = ac.getBean("airportServiceImpl",AirportServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list",airportService.show());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	} 
}
