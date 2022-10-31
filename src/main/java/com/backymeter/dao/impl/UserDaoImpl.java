package com.backymeter.dao.impl;

import com.backymeter.pojo.User;
import com.backymeter.dao.BaseDao;
import com.backymeter.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	public User queryUserByAccount(String account) {
		
		String sql = "select * from t_user where account = ?";
		
		return queryForOne(User.class, sql, account);
	
	}
	
	public User queryUserByAccountAndPassword(String account, String password) {
																//binary 有區分大小寫
		String sql = "select * from t_user where account=? and binary password=?";
		
		return queryForOne(User.class, sql, account, password);
	}
	
	public int saveUser(User user) {
		
		String sql = "insert into t_user(account, username, password, salt, email, phone, gender) "
				   + "values(?, ?, ?, ?, ?, ?, ?)";
		return update(sql, user.getAccount(), user.getUserName(), user.getPassword(),
					  user.getSalt(), user.getEmail(), user.getPhone(), user.getGender());
	
	}
	
	
}
