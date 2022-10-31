package com.backymeter.service.impl;

import com.backymeter.dao.UserDao;
import com.backymeter.dao.impl.UserDaoImpl;
import com.backymeter.pojo.User;
import com.backymeter.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	
	public void registUser(User user) {
			userDao.saveUser(user);	
	}
	
	public User login(User user) {
		return userDao.queryUserByAccountAndPassword(user.getAccount(), user.getPassword());
	}
	
	public boolean existsAccount(String account) {
		
		if(userDao.queryUserByAccount(account) == null) {
			return false;
		}
		 
		return true;
	}
	
	public String createVerification() {
		
		String verification = String.format("%04d", ((int) (Math.random() * 10000)));
		return verification;
	}
	
}
