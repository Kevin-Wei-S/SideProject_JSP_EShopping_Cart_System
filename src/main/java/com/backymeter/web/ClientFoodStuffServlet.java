package com.backymeter.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;
import com.backymeter.service.FoodStuffService;
import com.backymeter.service.impl.FoodStuffServiceImpl;
import com.backymeter.utils.WebUtils;

public class ClientFoodStuffServlet extends BaseServlet {
	
	private FoodStuffService foodStuffService = new FoodStuffServiceImpl();
	
	// 處理分頁-購物車商場
	protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 8);
		String url = "http://localhost:8080/BM02/client/foodStuffServlet?action=page";
		Page<FoodStuff> page = foodStuffService.page(pageNo, pageSize, url);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/pages/client/foodStuffMart.jsp").forward(req, resp);
	}
	
	 // 處理 分頁-搜尋價格區間
	protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
		int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 8);
		int beginPrice = WebUtils.parseInt(req.getParameter("beginPrice"), 0);
		int endPrice = WebUtils.parseInt(req.getParameter("endPrice"), Integer.MAX_VALUE);
		
		//String url = "http://localhost:8080/BM02/client/foodStuffServlet?action=pageByPrice&beginPrice=" + beginPrice + "&endPrice=" + endPrice;
		// 上述其他寫法
		StringBuilder sb = new StringBuilder("http://localhost:8080/BM02/client/foodStuffServlet?action=pageByPrice");
		if(req.getParameter("beginPrice") != "") {
			sb.append("&beginPrice=").append(req.getParameter("beginPrice"));
		}
		if(req.getParameter("endPrice") != "") {
			sb.append("&endPrice=").append(req.getParameter("endPrice"));
		}		
		String url = sb.toString();
		
		Page<FoodStuff> page = foodStuffService.pageByPrice(pageNo, pageSize, url, beginPrice, endPrice);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/pages/client/search_result.jsp").forward(req, resp);
		
	}
	
	
	
	
	
	
	
	
	
}
