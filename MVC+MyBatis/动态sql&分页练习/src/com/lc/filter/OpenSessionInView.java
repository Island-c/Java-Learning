package com.lc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.lc.utils.MyBatisUtils;


@WebFilter("/*")
public class OpenSessionInView implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		SqlSession session=null;
		try {
			session= MyBatisUtils.getSession();
			
			chain.doFilter(request, response);
			
			session.commit(); //提交session
			
		}catch (Exception e ) {
			session.rollback(); //回滚session
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSession(); //关闭session
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
