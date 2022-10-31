package com.backymeter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.backymeter.utils.JdbcUtils;

public class TransactionFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		try {
			
			chain.doFilter(req, resp);
			JdbcUtils.commitAndClose();
			
		} catch(Exception e) {
			
			JdbcUtils.rollbackAndClose();
			e.printStackTrace();
			// web.xml配置, 為了讓Tomcat捕獲到異常, 須拋出例外.
			throw new RuntimeException(e);
			
		}
	}
	
}
