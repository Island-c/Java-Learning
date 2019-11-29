package com.lc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lc.dao.FlowerDao;
import com.lc.pojo.Flower;

public class FlowerDaoImpl implements FlowerDao{

	
	/**
	 * 数据访问层要有异常处理。
	 */
	@Override
	public List<Flower> selAll() {
		
		//JDK1.7开始，后面的泛型可以省略
		List<Flower> list = new ArrayList<>(); 
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","root");
			
			ps=conn.prepareStatement("select * from flower");
			 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				list.add(new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return list;
	}

	@Override
	public int insFlower(Flower flower) {
		//JDK1.7开始，后面的泛型可以省略
		Connection conn=null;
		PreparedStatement ps=null;
		int index=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","root");
			
			ps=conn.prepareStatement("insert into flower values(default,?,?,?)");
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			
			index = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}

	
}
