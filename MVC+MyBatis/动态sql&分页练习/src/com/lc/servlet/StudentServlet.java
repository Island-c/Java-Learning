package com.lc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lc.pojo.PageInfo;
import com.lc.pojo.Student;
import com.lc.service.StudentService;
import com.lc.service.impl.StudentServiceImpl;


@WebServlet("/page")
public class StudentServlet extends HttpServlet{

	private StudentService studentservice = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		int pageNumber=1;
		String pageNumberStr= req.getParameter("pageNumber");
		if(pageNumberStr != null && !"".equals(pageNumberStr)) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		System.out.println("pageNumber = "+pageNumber);
		
		int pageSize=2;
		
		String  pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr != null && !"".equals(pageSizeStr)){
			pageSize =Integer.parseInt(pageSizeStr);
		}
		
		String student_name= req.getParameter("student_name");
		String teacher_name= req.getParameter("teacher_name");
		
		PageInfo pi = studentservice.showPage(pageNumber, pageSize, student_name, teacher_name);
		
		List<Student> list = pi.getList();	
		
		JSONArray studentJsonArray = new JSONArray();
		studentJsonArray = JSON.parseArray(JSON.toJSONString(list));
		
		resp.getWriter().write(studentJsonArray.toString());
		//req.setAttribute("pageinfo", pi);
		
		//req.getRequestDispatcher("/index.html").forward(req,resp);
		
		
	}
	
	
	
}
