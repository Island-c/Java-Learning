package com.lc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.pojo.Account;
import com.lc.service.AccountService;
import com.lc.service.impl.AccountServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private AccountService accService = new AccountServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//接参数
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		accIn.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		//调服务层
		int index = accService.transfer(accIn, accOut);
		
		if(index == AccountService.SUCCESS) {
			//成功
			resp.sendRedirect("/bank/show");
			
		}else {
			req.getSession().setAttribute("code", index);
			resp.sendRedirect("/bank/error/error.jsp");
		}
		
		
		
		
	}
}
