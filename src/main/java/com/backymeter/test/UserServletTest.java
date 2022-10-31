package com.backymeter.test;

import java.lang.reflect.Method;

import org.junit.Test;

public class UserServletTest {
	
	@Test
	public void login() {
		System.out.println("這是調用login()方法");
	}
	
	@Test
	public void regist() {
		System.out.println("這是調用regist()方法");
	}
	
	@Test
	public void updateAccount() {
		System.out.println("這是調用updateAccont()方法");
	}
	
	@Test
	public void updatePassword() {
		System.out.println("這是調用updatePassword()方法");
	}
	
	public static void main(String[] args) throws Exception {
		
		String action = "updatePassword";
		
		Method method = UserServletTest.class.getDeclaredMethod(action);
		method.invoke(new UserServletTest());
		
		
	}
	
}
