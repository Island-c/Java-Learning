package com.lc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��������ʹ��
 * 
 *  
 * 
 * @author Ice
 *
 */
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy(�ұ�������)");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter(��һ�����������ұ�ִ����)" );
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//�ж�session
		HttpSession hs  =((HttpServletRequest) request).getSession();
		if(hs.getAttribute("user") == null) {
			
			((HttpServletResponse)response).sendRedirect("/a/login.jsp");
		}else {
			//���У�ת���������servlet
			chain.doFilter(request, response); //��仰ִ����Ϻ�response�Ѿ�����servlet��Ӧ�����ݣ����Լ�������
		}
		System.out.println("MyFilter.doFilter(��һ�����������ұ�ִ�������)" );
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter.init(�ұ���ʼ����)");
	}
	
	
	

}
