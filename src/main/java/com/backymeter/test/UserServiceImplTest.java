package com.backymeter.test;

import org.junit.Test;
import com.backymeter.pojo.User;
import com.backymeter.service.UserService;
import com.backymeter.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	UserService userService = new UserServiceImpl();
	User user = new User(null, "Awaken", "Awaken", "Awaken@backymeter.com",
							   "root", "0911111111", "", "M");
	
	@Test
	public void registUser() {
		userService.registUser(user);
		
	}
	
	@Test
	public void login() {
		if(userService.login(user) != null) {
			System.out.println("登入成功!");
		} else {
			System.out.println("登入失敗! 請再次檢查帳號密碼!");
		}
	}
	
	@Test
	public void existsAccount() {
		if(userService.existsAccount("admin") == true) {
			System.out.println("此帳號已被註冊!");
		} else {
			System.out.println("此帳號可以使用!");
		}
	}
	
	@Test
	public void createVerification() {
		System.out.println(userService.createVerification());
	}
	
}
