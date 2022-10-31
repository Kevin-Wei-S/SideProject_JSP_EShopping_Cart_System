package com.backymeter.service;

import com.backymeter.pojo.User;

public interface UserService {
	
	// 一項業務一個方法
	// 註冊-業務
	public void registUser(User user);
	
	// 登入-業務
	public User login(User user);
	
	// 確認帳戶名是否可用-業務
	public boolean existsAccount(String account); 
	
	// 生成驗證碼
	public String createVerification();
	
}
