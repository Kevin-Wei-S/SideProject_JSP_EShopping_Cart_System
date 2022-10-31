package com.backymeter.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.backymeter.pojo.User;
import com.backymeter.service.UserService;
import com.backymeter.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	private final String LOGIN_SUCCESS = "pages/user/login_success.jsp";
	private final String LOGIN = "pages/user/login.jsp";
	private UserService userService = new UserServiceImpl();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		User loginUser = new User(null, account, null, null, password, null, null, null);
		
		if(userService.login(loginUser) == null) {	
			
			if(account=="" || password=="") {
				req.setAttribute("loginError", "帳號及密碼不能為空白!");
			} else {			
				req.setAttribute("loginError", "請輸入正確帳號及密碼!");
			}
			
			req.getRequestDispatcher(LOGIN).forward(req, resp);
			
		} else {
			
			req.getRequestDispatcher(LOGIN_SUCCESS).forward(req, resp);
		
		}

	}
	
}
