package com.lc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.lc.dao.UserDao;
import com.lc.dao.impl.UserDaoImpl;
import com.lc.pojo.User;
import com.lc.service.UserService;

public class UserServiceImpl implements UserService{
	//声明Dao层对象
	UserDao ud =new UserDaoImpl();
	//声明日志对象
	Logger logger =Logger.getLogger(UserServiceImpl.class);
	
	//用户登录
	@Override
	public User checkUserLoginService(String uname, String pwd) {

		//打印日志
		logger.debug(uname+"发起登陆请求");
		User u=ud.checkUserLoginDao(uname, pwd);
		if(u != null) {
			logger.debug(uname+"登陆成功");
		}else {
			logger.debug(uname+"登陆失败");
		}
		return u;
	}

	//修改用户密码
	@Override
	public int userChangePwdService(String newPwd, int uid) {
		
		logger.debug(uid+"发起修改密码请求");
		int index= ud.userChangePwdDao(newPwd,uid);
		if(index >0) {
			logger.debug(uid+"密码修改成功");
		}else {
			logger.debug(uid+"密码修改失败");
		}
		
		return index;
	}

	//获取所有用户信息
	@Override
	public List<User> userShowService() {
		List<User> lu =  ud.userShowDao();
		logger.debug("显示所有用户信息："+lu);
		return lu;
	}

	//用户注册
	@Override
	public int userRegService(User u) {
		int index = ud.UserRegDao(u);
		
		return index;
	}
}
