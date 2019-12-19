package com.lc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/pool")
public class Pool extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		try {
			Context ctx = new InitialContext(); 
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/test");
			Connection conn =ds.getConnection();
			PreparedStatement ps  = conn.prepareStatement("select * from flower");
			ResultSet rs = ps.executeQuery();
			PrintWriter out = resp.getWriter();
			while(rs.next()) {
				out.println(rs.getInt(1)+"     "+rs.getString(2));
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
