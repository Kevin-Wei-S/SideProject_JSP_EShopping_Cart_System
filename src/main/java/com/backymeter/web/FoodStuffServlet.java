package com.backymeter.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backymeter.dao.impl.FoodStuffDaoImpl;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;
import com.backymeter.service.FoodStuffService;
import com.backymeter.service.impl.FoodStuffServiceImpl;
import com.backymeter.utils.WebUtils;

public class FoodStuffServlet extends BaseServlet {
	
	private FoodStuffService foodStuffService = new FoodStuffServiceImpl();
	
	// 處理品項-新增
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FoodStuff newStuff = WebUtils.copyParamToBean(req.getParameterMap(), new FoodStuff());
		int addInfo = foodStuffService.addFoodStuff(newStuff);
		// 重定向分頁
		int page = new FoodStuffDaoImpl().getPageTotal(Page.PAGE_SIZE);
		if(addInfo==-1) {
			req.setAttribute("addInfo", "新增失敗! 請再次確認輸入內容!");
			req.getRequestDispatcher("/pages/manager/foodStuff_edit.jsp").forward(req, resp); 
		} else {
			resp.sendRedirect(req.getContextPath() + "/manager/foodStuffServlet?action=page&page=" + page);
		}
		
	}
	
	// 處理品項-刪除
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		foodStuffService.deleteFoodStuffById(id);
		// 獲取重定向分頁
		String page = req.getParameter("page");
		resp.sendRedirect(req.getContextPath() + "/manager/foodStuffServlet?action=page&page=" + page);
		
	}
	
	// 處理更改並保存更新
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer preId = WebUtils.parseInt(req.getParameter("preId"), 0);
		FoodStuff newFoodStuff = WebUtils.copyParamToBean(req.getParameterMap(), new FoodStuff());		
		int	updateInfo = foodStuffService.updateFoodStuff(newFoodStuff, preId);
		// 獲取分頁參數
		String page = req.getParameter("page");
		
		if(updateInfo==-1) {
			req.setAttribute("updateInfo", "更新失敗! 請再次確認輸入格式!");
			req.getRequestDispatcher("/pages/manager/foodStuff_update.jsp").forward(req, resp);
		} else {
			//resp.sendRedirect(req.getContextPath() + "/manager/foodStuffServlet?action=list");
			resp.sendRedirect(req.getContextPath() + "/manager/foodStuffServlet?action=page&page=" + page);
		}
	}
	
	// 實品管理頁面 獲取所有品項清單
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<FoodStuff> foodStuffList = foodStuffService.queryFoodStuffs();
		req.setAttribute("foodStuffList", foodStuffList);
		req.getRequestDispatcher("/pages/manager/foodStuff_manager.jsp").forward(req, resp);
		
		
	}
	
	// 更改品項頁面 獲得回填數據 
	protected void getFoodStuff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
		FoodStuff foodStuff = foodStuffService.queryFoodStuffById(id);
		req.setAttribute("foodStuff", foodStuff);
		req.getRequestDispatcher("/pages/manager/foodStuff_update.jsp").forward(req,resp);
		
	}
	
	// 處理食品管理分頁
	protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer pageNo = WebUtils.parseInt(req.getParameter("page"), 1);
		Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);	
		String url = "http://localhost:8080/BM02/manager/foodStuffServlet?action=page";
		Page<FoodStuff> page = foodStuffService.page(pageNo, pageSize, url);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/pages/manager/foodStuff_manager.jsp").forward(req, resp);
		
	}
	
}
