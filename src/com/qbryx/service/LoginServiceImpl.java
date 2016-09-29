package com.qbryx.service;

import com.qbryx.dao.UserDao;
import com.qbryx.dao.UserDaoImpl;
import com.qbryx.dm.User;

public class LoginServiceImpl implements LoginService {
	
	private UserDao userDao;
	
	public LoginServiceImpl(){
		userDao = new UserDaoImpl();
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getUser(username);
	}
}
