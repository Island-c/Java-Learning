package com.lc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lc.dao.UserDao;
import com.lc.vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserInfo(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		User u =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardway?characterEncodind=utf-8&serverTimezone=UTC","root","root");
			
			String sql ="select * from user where uname=?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				int uid = rs.getInt("uid");
				String uname=rs.getString("uname");
				double price = rs.getDouble("price");
				String location=rs.getString("location");
				String des=rs.getString("des");
				u=new User(uid, uname, price, location, des);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
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
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return u;
	}
	public static void main(String[] args) {
		UserDaoImpl a = new UserDaoImpl();
		User u = a.getUserInfo("утпе");
		System.out.println(u.getDesc());
	}
}
