package com.backymeter.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.CartItem;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.service.FoodStuffService;
import com.backymeter.service.impl.FoodStuffServiceImpl;
import com.backymeter.utils.WebUtils;

public class CartServlet extends BaseServlet {
	
	private FoodStuffService foodStuffService = new FoodStuffServiceImpl(); 
	
	protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart= (Cart) req.getSession().getAttribute("cart");
		int id = WebUtils.parseInt(req.getParameter("foodStuffId"), 0);
		int page = WebUtils.parseInt(req.getParameter("page"), 0);
		
		FoodStuff foodStuff = foodStuffService.queryFoodStuffById(id);
		CartItem item = new CartItem(foodStuff.getId(), foodStuff.getName(), 1, foodStuff.getPrice(), foodStuff.getPrice(), foodStuff.getImg_path());
		
		if(cart==null) {
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		
		cart.addItem(item);
		
		req.getSession().setAttribute("newAdd", item.getName());
		
		resp.sendRedirect(req.getHeader("Referer"));
	}
	
	protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		
		if(cart!=null) {
			cart.deleteItem(id);
		}
		req.getSession().setAttribute("newAdd", "");
		resp.sendRedirect(req.getHeader("Referer"));
	
	}
	
	protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(cart!=null) {
			cart.clear();
		}
		resp.sendRedirect(req.getHeader("Referer"));
	}
	
	
	protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Cart cart= (Cart) req.getSession().getAttribute("cart");
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		int count = WebUtils.parseInt(req.getParameter("count"), 0);
		
		if(cart != null) {
			cart.updateCount(id, count);
		}
		
		resp.sendRedirect(req.getHeader("Referer"));
	
	}
		
	// GJ! 邏輯挑戰賽 - PASS
	/*private FoodStuffService foodStuffService = new FoodStuffServiceImpl(); 
	
	protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 登入時 創建的cart
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		// 獲取參數-Id	
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		// 獲取品項-示意圖
		String img_path = req.getParameter("img_path");
		// 調用 FoodStuffService 獲取所需數據
		FoodStuff foodStuff = foodStuffService.queryFoodStuffById(id);
		// 判斷購物車是否已存在此item
		List<CartItem> items;
		
		if(cart!=null && cart.getItems()!=null) {
			items = cart.getItems();
		} else {
			items = null;
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		// 將購物車裡的items所有id都放入idList集合
		if(items!=null && items.size()!=0) {
			for(int i=0 ; i<items.size() ; i++) {
				idList.add(items.get(i).getId());
			}
		}
		
		// 判斷購物車裡是否有欲添加的品項
		if(idList!=null && idList.contains(id)) {
			// 獲取此id品項 並將數量+1 且單品總金額更新
			for(int i=0 ; i<items.size() ; i++) {
				if(items.get(i).getId()==id) {
					items.get(i).setCount(items.get(i).getCount()+1);
					items.get(i).setTotalPrice(BigDecimal.valueOf(items.get(i).getCount()).multiply(items.get(i).getPrice()));
				}
			}
		// 如果無此品項 新增item
		} else if(foodStuff!=null) {
			CartItem addItem = new CartItem();
			if(items==null) {
				items = new ArrayList<CartItem>();
			}
			addItem.setId(id);
			addItem.setName(foodStuff.getName());
			addItem.setCount(1);
			addItem.setPrice(foodStuff.getPrice());
			BigDecimal totalPrice = (BigDecimal.valueOf(addItem.getCount())).multiply(addItem.getPrice()) ;
			addItem.setTotalPrice(totalPrice);
			addItem.setImg_path(img_path);
			items.add(addItem);			
		}
		
		// 將修改過後的cart 更新 修改前的cart
		req.getSession().setAttribute("cart", new Cart());
		Cart newCart = (Cart) req.getSession().getAttribute("cart");
		// 更新Cart-items
		newCart.setItems(items);
		// 更新Cart-totalCount
		int totalCount = 0;
		for(CartItem item:items) {
			totalCount += item.getCount();
		}
		newCart.setTotalCount(totalCount);
		// 更新Cart-totalPrice
		BigDecimal totalPrice = new BigDecimal(0);
		for(CartItem item:items) {
			totalPrice = totalPrice.add(item.getTotalPrice());
		}
		newCart.setTotalPrice(totalPrice);
		// 重置Session-Cart
		req.getSession().setAttribute("cart", newCart);
		
		// 重定向到購物車
		resp.sendRedirect("http://localhost:8080/BM02/pages/cart/cart.jsp");

	}
		
	protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		List<CartItem> items = cart.getItems();
		for(int i=0 ; i<items.size(); i++) {
			if(items.get(i).getId()==id) {
				items.remove(i);
			}
		}
		cart.setItems(items);
		req.getSession().setAttribute("cart", cart);
		resp.sendRedirect(req.getContextPath() + "/cartServlet?action=addItem");
	}
	
	protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int count = WebUtils.parseInt(req.getParameter("count"), 0);
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		List<CartItem> items = cart.getItems();
		for(int i=0 ; i<items.size(); i++) {
			if(items.get(i).getId()==id) {
				items.get(i).setCount(count);
				items.get(i).setTotalPrice(BigDecimal.valueOf(items.get(i).getCount()).multiply(items.get(i).getPrice()));
			}
		}
		
		cart.setItems(items);
		BigDecimal totalPrice = new BigDecimal(0);
		int totalCount = 0;
		for(CartItem item:items) {
			totalPrice = totalPrice.add(item.getTotalPrice());
			totalCount += item.getCount();
		}
		cart.setTotalPrice(totalPrice);
		cart.setTotalCount(totalCount);
		req.getSession().setAttribute("cart", cart);
		resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
		
	}
	
	protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().setAttribute("cart", null);
		resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
	}*/
	
}
