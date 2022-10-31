package com.backymeter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.backymeter.pojo.User;

public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		 User loginUser= (User) req.getSession().getAttribute("user");
		
		if( loginUser==null || !"admin".equals(loginUser.getAccount())){
			
			req.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
			
		} else {
			
			chain.doFilter(request, response);
			
		}
		
	}
	
}
