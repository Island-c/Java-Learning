package com.lc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lc.dao.UserDao;
import com.lc.pojo.User;


public class UserDaoImpl implements UserDao {

	//根据用户名和密码查询用户信息
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
	
		//声明jdbc对象
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		//声明变量
		User u =null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardway?characterEncoding=utf-8&serverTimezone=UTC","root","root");
			//创建sql命令
			String sql = "select * from t_user where uname=? and pwd = ? "; 
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2,pwd);
			//执行sql
			rs=ps.executeQuery();
			//遍历结果
			while(rs.next()) {
				//给变量赋值
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接失败");
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
			//关闭资源
		}
		//返回结果
		return u;
	}

	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		// 声明jdbc对象
		Connection conn =null;
		PreparedStatement ps = null;
		//创建变量
		int index =0;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardway?characterEncoding=utf-8&serverTimezone=UTC","root","root");
			//创建sql命令
			String sql = "update t_user set pwd=? where uid=?";
			//创建SQL命令对象
			ps= conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			//执行
			index = ps.executeUpdate();
			//关闭资源
			//返回结果
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接失败");
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}
	@Override
	public List<User> userShowDao() {
		//声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		//创建对象
		List<User> user_list = new ArrayList<User>();
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardway?characterEncoding=utf-8&serverTimezone=UTC","root","root");
			//创建sql 语句
			String sql= "select * from t_user";
			//创建查询对象
			ps = conn.prepareStatement(sql);
			//占位符赋值
			//执行查询语句
			rs = ps.executeQuery();
			
			//获取查询结果
			while(rs.next()) {
				User u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				user_list.add(u);
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
		return user_list;

	}
	
	public static void main(String[] args) {
		UserDaoImpl a = new UserDaoImpl();
		List<User> ls =a.userShowDao();
		for(User u :ls ) {
			System.out.println(u.getUname());
		}
	}

	//用户注册
	@Override
	public int UserRegDao(User u) {
		//创建jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		//声明变量
		int index=-1;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hardway?characterEncoding=utf-8&serverTimezone=UTC","root","root");
			//写sql
			String sql ="insert t_user values (default,?,?,?,?,?)";
			//生成sql命令对象
			ps=conn.prepareStatement(sql);
			//填充占位符
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3,u.getSex());
			ps.setInt(4,u.getAge());
			ps.setString(5,"2018-8-8");
			
			index = ps.executeUpdate();
			
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
		}

		
		
		return index;
	}

}
