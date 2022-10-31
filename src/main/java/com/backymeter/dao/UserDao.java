package com.backymeter.dao;

import com.backymeter.pojo.User;

public interface UserDao {
	
	// 根據 帳號 查詢用戶訊息
	// 如返回null 說明無此用戶 反之亦然
	public User queryUserByAccount(String account);
	
	// 根據 帳號密碼 查詢比對進行登入
	// 返回null 說明 帳號 或(及) 密碼有誤 反之亦然
	public User queryUserByAccountAndPassword(String account, String password);
	
	// 保存用戶訊息
	public int saveUser(User user);
		
		 	
}
