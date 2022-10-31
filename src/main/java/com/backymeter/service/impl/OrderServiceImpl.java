 package com.backymeter.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.backymeter.dao.OrderDao;
import com.backymeter.dao.OrderItemDao;
import com.backymeter.dao.impl.OrderDaoImpl;
import com.backymeter.dao.impl.OrderItemDaoImpl;
import com.backymeter.pojo.Cart;
import com.backymeter.pojo.CartItem;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Order;
import com.backymeter.pojo.OrderItem;
import com.backymeter.service.FoodStuffService;
import com.backymeter.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private FoodStuffService foodStuffService = new FoodStuffServiceImpl();
	
	public String createOrder(Cart cart, Integer userId) {
		
		// 判斷訂單-各項目庫存-是否足夠 
		for(CartItem item : cart.getItems().values()) {
			
			FoodStuff foodStuff = foodStuffService.queryFoodStuffById(item.getId());
			
			// 任一項庫存不足 返回null 訂單未完成新增
			if(item.getCount() > foodStuff.getStock()) {
				return null;
			}
			
		}
		
		// 庫存足夠狀況下
		// 訂單號生成-運用時間戳 同時間下單會有重複的可能性 加上唯一id 成為唯一訂單號
		String orderId = System.currentTimeMillis() + "" + userId;
		// 創建新訂單
		Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 
						   			0, userId);
		
		orderDao.saveOrder(order);	
		
		// 人為製造錯誤, 測試事務管理.
		//int i = 101/0;
		
		// 建立新訂單品項
		for(CartItem item : cart.getItems().values()) {
			// 儲存品項同時 須更新 庫存數量 及 銷售數量
			orderItemDao.saveOrderItem(new OrderItem(null, item.getName(), item.getCount(),
									   		item.getPrice(), item.getTotalPrice(), order.getOrder_id()));
			// 更新庫存數量 資料庫庫存 減去 訂單數量
			FoodStuff foodStuff = foodStuffService.queryFoodStuffById(item.getId());
			foodStuff.setSales(foodStuff.getSales()+item.getCount());  
			foodStuff.setStock(foodStuff.getStock()-item.getCount());
									   	 
			foodStuffService.updateFoodStuff(foodStuff, foodStuff.getId());
		}
		
		cart.clear();
		
		return orderId;
		
	}
	
	// 確定 createOrder 返回值為null 方可執行 否則將重複下單 且不便獲取訂單號
	public Map<String, Integer> shortageStock(Cart cart, Integer userId) {
		
		String orderId = createOrder(cart, userId);
		
		if(orderId == null) {
			
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			
			for(CartItem item : cart.getItems().values()) {
				FoodStuff foodStuff = foodStuffService.queryFoodStuffById(item.getId());
				if(item.getCount()>foodStuff.getStock()) {
					map.put(item.getName(), foodStuff.getStock());
				}
			}
			
			return map;
		}
		
		return null;
	}
	
	public List<Order> showAllOrders(){
		
		return orderDao.queryForOrders();
		
	}
	
	public void sendOrder(String orderId, Integer status) {
		
		orderDao.changeStatus(orderId, status);
		
	}
	
	public List<OrderItem> showOrderDetails(String orderId) {
		
		return orderItemDao.queryOrderItems(orderId); 
	}
	
	
	public Order getSingleOrder(String orderId) {
		
		return orderDao.querySingleOrder(orderId);
		
	}
	
	public int getOrderCount(List<OrderItem> list) {
		
		int orderCount = 0;
		for(OrderItem item : list)
			orderCount += item.getCount();
		
		return orderCount;
		
	}
	
	
	public List<Order> showUserOrders(Integer userId) {
		
		return orderDao.queryUserOrders(userId);
		
	}
	
	
}
