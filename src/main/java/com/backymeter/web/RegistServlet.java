package com.backymeter.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backymeter.pojo.User;
import com.backymeter.service.UserService;
import com.backymeter.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	
	private final String REGIST_SUCCESS = "pages/user/regist_success.jsp";								   
	private final String REGIST = "pages/user/regist.jsp";
	private  UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		
		String userName = req.getParameter("userName");
		String account = req.getParameter("account");
		String email = req.getParameter("email");
		String cellPhone = req.getParameter("cellPhone");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String confirm = req.getParameter("confirm");
		String confirmNums = (String) req.getSession().getAttribute("confirmNums");
		
		if(!confirmNums.equalsIgnoreCase(confirm)) {
			
			req.setAttribute("registError", "請輸入正確驗證碼!");
			req.getRequestDispatcher(REGIST).forward(req, resp);
			System.out.println(req.getHeader("referer"));
		
		} else if(userService.existsAccount(account)) {
			
			req.setAttribute("registError", "此帳號已被註冊!");
			req.getRequestDispatcher(REGIST).forward(req, resp);
		
		} else {
		
			userService.registUser(new User(null, account, userName, email, password, cellPhone, "", gender));
		
			req.getRequestDispatcher(REGIST_SUCCESS).forward(req, resp);
		}			
		
	} 

}
