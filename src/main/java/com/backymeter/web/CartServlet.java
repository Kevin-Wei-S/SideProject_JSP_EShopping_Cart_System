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
		
	// GJ! ??????????????? - PASS
	/*private FoodStuffService foodStuffService = new FoodStuffServiceImpl(); 
	
	protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ????????? ?????????cart
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		// ????????????-Id	
		int id = WebUtils.parseInt(req.getParameter("id"), 0);
		// ????????????-?????????
		String img_path = req.getParameter("img_path");
		// ?????? FoodStuffService ??????????????????
		FoodStuff foodStuff = foodStuffService.queryFoodStuffById(id);
		// ?????????????????????????????????item
		List<CartItem> items;
		
		if(cart!=null && cart.getItems()!=null) {
			items = cart.getItems();
		} else {
			items = null;
		}
		
		List<Integer> idList = new ArrayList<Integer>();
		// ??????????????????items??????id?????????idList??????
		if(items!=null && items.size()!=0) {
			for(int i=0 ; i<items.size() ; i++) {
				idList.add(items.get(i).getId());
			}
		}
		
		// ?????????????????????????????????????????????
		if(idList!=null && idList.contains(id)) {
			// ?????????id?????? ????????????+1 ????????????????????????
			for(int i=0 ; i<items.size() ; i++) {
				if(items.get(i).getId()==id) {
					items.get(i).setCount(items.get(i).getCount()+1);
					items.get(i).setTotalPrice(BigDecimal.valueOf(items.get(i).getCount()).multiply(items.get(i).getPrice()));
				}
			}
		// ?????????????????? ??????item
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
		
		// ??????????????????cart ?????? ????????????cart
		req.getSession().setAttribute("cart", new Cart());
		Cart newCart = (Cart) req.getSession().getAttribute("cart");
		// ??????Cart-items
		newCart.setItems(items);
		// ??????Cart-totalCount
		int totalCount = 0;
		for(CartItem item:items) {
			totalCount += item.getCount();
		}
		newCart.setTotalCount(totalCount);
		// ??????Cart-totalPrice
		BigDecimal totalPrice = new BigDecimal(0);
		for(CartItem item:items) {
			totalPrice = totalPrice.add(item.getTotalPrice());
		}
		newCart.setTotalPrice(totalPrice);
		// ??????Session-Cart
		req.getSession().setAttribute("cart", newCart);
		
		// ?????????????????????
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
