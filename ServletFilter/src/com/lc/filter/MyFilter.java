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
 * 过滤器的使用
 * 
 *  
 * 
 * @author Ice
 *
 */
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy(我被销毁了)");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter(第一个过滤器：我被执行了)" );
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//判断session
		HttpSession hs  =((HttpServletRequest) request).getSession();
		if(hs.getAttribute("user") == null) {
			
			((HttpServletResponse)response).sendRedirect("/a/login.jsp");
		}else {
			//放行，转到所请求的servlet
			chain.doFilter(request, response); //这句话执行完毕后，response已经有了servlet响应的数据，可以继续处理
		}
		System.out.println("MyFilter.doFilter(第一个过滤器：我被执行完毕了)" );
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter.init(我被初始化了)");
	}
	
	
	

}
