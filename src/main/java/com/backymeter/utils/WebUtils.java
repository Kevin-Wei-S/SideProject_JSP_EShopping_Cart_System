package com.backymeter.utils;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.backymeter.pojo.User;

public class WebUtils {
	
	// 映射 不僅屬性名與變數名要一致 且 setXXX() XXX也要與前兩者一致
	// 將 HttpServletRequest 轉成 Map 如此可在 Dao層 及 Service層運用 不局限於Web層 
	// 避免此方法與Web層高度耦合
	// public static void copyParamToBean(HttpServletRequest req, Object bean) {
	// public static Object copyParamToBean(Map map, Object bean) {
	// 使用泛型
	public static <T> T copyParamToBean(Map map, T bean) {
		try {
			
			//BeanUtils.populate(bean, req.getParameterMap());
			BeanUtils.populate(bean, map);

		} catch(Exception e) {
			
			e.printStackTrace();
		
		}
		
		return bean;
		
	}
	
	public static Integer parseInt(String strInt, Integer defaultValue) {
		
		try {
			return Integer.parseInt(strInt);
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
		return defaultValue;
	}
	
	// 以 目標Key 找尋 目標Cookie
	public static Cookie getTargetCookie(Cookie[] cookies, String targetKey) {
		
		if(cookies==null || targetKey==null || cookies.length==0) {
			return null;
		}
			
		for(Cookie cookie:cookies) {
			if(targetKey.equals(cookie.getName())) {
				return cookie;
			}
		}
			
		return null;
	}
	
	
}
