package com.backymeter.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.Order;
import com.backymeter.pojo.OrderItem;
import com.backymeter.pojo.User;
import com.backymeter.service.OrderService;
import com.backymeter.service.impl.OrderServiceImpl;
import com.backymeter.utils.JdbcUtils;
import com.backymeter.utils.WebUtils;

public class OrderServlet extends BaseServlet {
	
	private static OrderService orderService = new OrderServiceImpl();
	
	protected static synchronized void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		User loginUser = (User) req.getSession().getAttribute("user");
		if(loginUser==null) {
			
			req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
			return;
		}
		
		String orderId = null;
		
		// 為確保訂單結帳流程完整, 採手動提交事務, 如有例外則回滾事務.
		//try {
		// 更新應用-TransactionFilter	
		orderId = orderService.createOrder(cart, loginUser.getId());
			//JdbcUtils.commitAndClose();
		
		//} catch(Exception e) {
				
			//JdbcUtils.rollbackAndClose();
			//e.printStackTrace();
				
		//}

		req.getSession().setAttribute("orderId", orderId);
			
		if(orderId==null) {
			
			// 調用 shortageStock() 前請先確保 orderId為null 否則將重複下單 
			Map<String,Integer> shortageMap = orderService.shortageStock(cart, loginUser.getId());
			req.getSession().setAttribute("shortageMap", shortageMap);
			
		}
			
		resp.sendRedirect(req.getContextPath() + "/pages/order/checkout.jsp");
				
	}
	
	protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("user") != null) {	
			
			List<Order> orders = orderService.showAllOrders();
			req.setAttribute("orders", orders);
			req.getRequestDispatcher("/pages/order/manager_order.jsp").forward(req, resp);
		
		} else {
			
			resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");	
		
		}

	}
	
	protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderId = req.getParameter("orderId");
		Integer status = WebUtils.parseInt(req.getParameter("status"), 0);		
		orderService.sendOrder(orderId, status);
		
		resp.sendRedirect(req.getHeader("referer"));
		
	}
	
	protected void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderId = req.getParameter("orderId");
		List<OrderItem> detailList = orderService.showOrderDetails(orderId);
		Order order = orderService.getSingleOrder(orderId);
		int orderCount = orderService.getOrderCount(detailList);
		req.setAttribute("order", order);
		req.setAttribute("orderCount", orderCount);
		req.setAttribute("detailList", detailList);
		
		
		req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
		
		
	}
	
	protected void showUserOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user  = (User)req.getSession().getAttribute("user");
		
		if( user!=null ) {
			List<Order> orders = orderService.showUserOrders(user.getId());
			req.setAttribute("orders", orders);
			req.getRequestDispatcher("/pages/order/user_order.jsp").forward(req, resp);
		} else {
			
			resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
			
		}
		
	}
	
}
