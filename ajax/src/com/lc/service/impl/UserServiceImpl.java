package com.lc.service.impl;

import com.lc.dao.UserDao;
import com.lc.dao.impl.UserDaoImpl;
import com.lc.service.UserService;
import com.lc.vo.User;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	
	@Override

	public User getUserInfoService(String name) {
		
		
		return ud.getUserInfo(name);
		
	}
	
	

}
