package com.backymeter.web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.User;
import com.backymeter.service.UserService;
import com.backymeter.utils.WebUtils;
import com.google.gson.Gson;
import com.backymeter.service.impl.UserServiceImpl;

// 將 login 及 regist 兩項功能整合在一起 通常一整組模塊使用一個Servlet 
// 此為 user 模塊
public class UserServlet extends BaseServlet {
	
	private final String REGIST_SUCCESS = "pages/user/regist_success.jsp";
	private final String REGIST = "pages/user/regist.jsp";	
	private final String LOGIN_SUCCESS = "pages/user/login_success.jsp";
	private final String LOGIN = "pages/user/login.jsp";
	private  UserService userService = new UserServiceImpl();
	
		/* 擷取所有業務Servlet共項<String映射調用方法>至BaseServlet爾後使用繼承 讓程式碼更簡潔
		req.setCharacterEncoding("UTF-8");	
		
		String action = req.getParameter("action");	
		
		// 優化法 直接從String連結同名方法
		try {
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		/*// 如果處login業務
		if("login".equals(action)) {
			
			login(req, resp);
			
		// 如果處理regist業務	
		} else if("regist".equals(action)){
			
			regist(req, resp);
			
		// 未來可能處理user模塊新增業務 通常一整組模塊 使用一個Servlet	
		} else {	
		
		}*/
	
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		//User loginUser = new User(null, account, null, null, password, null, null, null);
		
		// 將參數注入Bean映射
		
		User beanUser = WebUtils.copyParamToBean(req.getParameterMap(), new User());
		
		User loginUser = userService.login(beanUser);

		if(loginUser == null) {		
			if(account.trim()=="" || password.trim()=="") {
				req.setAttribute("loginError", "帳號及密碼不能為空白!");
			} else {			
				req.setAttribute("loginError", "請輸入正確帳號及密碼!");
			}
			req.getRequestDispatcher(LOGIN).forward(req, resp);	
		} else {
			// 保存用戶登入的訊息到Session域中
			HttpSession session = req.getSession();
			session.setAttribute("user", loginUser);
			// 如果為管理員 在Session域中 新增login 開啟管理者功能
			if("admin".equals(loginUser.getAccount())){
				session.setAttribute("admin", "admin");
			}
			// 設置Cookie 進行免帳號登入
			Cookie cookie = new Cookie("account", account);
			resp.addCookie(cookie);
			
			resp.sendRedirect(LOGIN_SUCCESS);
		}
		
	}
	
	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String userName = req.getParameter("userName");
		String account = req.getParameter("account");
		String email = req.getParameter("email");
		String phone= req.getParameter("phone");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");
		String salt = req.getParameter("salt");
		String code = req.getParameter("code");
		String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
		
		req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
		
		/*try {
			
			User user = new User();
			System.out.println("User注入之前: " + user);
			// 把所有請求參數都注入到user對象中
			BeanUtils.populate(user, req.getParameterMap());
			System.out.println("User注入之後: " + user);
		
		} catch(Exception e) {
		
			e.printStackTrace();
		
		}*/

		
		if(token==null || !token.equalsIgnoreCase(code)) {
			
			req.setAttribute("registError", "請輸入正確驗證碼!");
			req.getRequestDispatcher(REGIST).forward(req, resp);
		
		} else if(userService.existsAccount(account)) {
			
			req.setAttribute("registError", "此帳號已被註冊!");
			req.getRequestDispatcher(REGIST).forward(req, resp);
		
		} else {
			
			// 將參數注入Bean映射
			//User registUser = new User();
			//WebUtils.copyParamToBean(req.getParameterMap(), registUser);
			User registUser = WebUtils.copyParamToBean(req.getParameterMap(), new User());
			userService.registUser(registUser);
			// 註冊完成 自動登入
			User user = userService.login(registUser);
			req.getSession().setAttribute("user", user);
			// 下次造訪 免帳號登入
			resp.addCookie(new Cookie("account", account));
			//userService.registUser(new User(null, account, userName, email, password, cellPhone, "", gender));
	
			resp.sendRedirect(req.getContextPath() + "/" + REGIST_SUCCESS);
		}			
		
	}
	
	// 登出 讓Session立即超時
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 讓Session立即超時
		req.getSession().invalidate();
		// 重定向至首頁
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
		
	}
	
	// 生成驗證碼
	/*protected void verify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String verification = userService.createVerification();
		req.getSession().setAttribute("verification", verification);
		
		req.getRequestDispatcher("/pages/forward/regist.jsp").forward(req, resp);
		
	}*/
	
	// 應用AJAX及jQuery-$.getJSON(url, data, callback)$
	protected void doubleAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String account = req.getParameter("account");		
		boolean existsAccount = userService.existsAccount(account);
			
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("existsAccount", existsAccount);
		Gson gson = new Gson();
		String json = gson.toJson(resultMap);
		resp.getWriter().write(json);
		//resp.getWriter().write("{\"errorInfo\":\"" + errorInfo + "\"}");
		
		
	}
	

}

