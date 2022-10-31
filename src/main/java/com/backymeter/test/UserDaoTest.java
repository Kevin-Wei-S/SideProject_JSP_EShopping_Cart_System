package com.backymeter.test;

import org.junit.Test;
import com.backymeter.pojo.User;
import com.backymeter.dao.UserDao;
import com.backymeter.dao.impl.UserDaoImpl;

public class UserDaoTest {
	
	UserDao userDao = new UserDaoImpl();
	
	@Test
	public void queryUserByAccount() {
		
		if(userDao.queryUserByAccount("few") == null) {
			System.out.println("此帳號可用!");
		} else {
			System.out.println("此帳號已被註冊!");
		}
		
	}
	
	@Test
	public void queryUserByAccountAndPassword() {
		
		if(userDao.queryUserByAccountAndPassword("fewfe", "wefew") != null ) {
			System.out.println("登入成功!");
		} else {
			System.out.println("登入失敗, 請再次確認帳號密碼!");
		}
		
		
	}
	
	@Test
	public void savaUser() {
		
		if(userDao.saveUser(new User(null, "Hand-On", "sdf", "sdf", "fds", "fdsfds", "", "M")) != -1) {
			System.out.println("恭喜您! 註冊成功!");
		} else {
			System.out.println("註冊失敗, 請再次確認會員資料!");
		}
		
	}

	
}
