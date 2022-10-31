package com.backymeter.dao;

import java.util.List;

import com.backymeter.pojo.Order;

public interface OrderDao {
	
	public int saveOrder(Order order);
	
	public List<Order> queryForOrders();
	
	public int changeStatus(String orderId, Integer status);
	
	public Order querySingleOrder(String orderId);
	
	public List<Order> queryUserOrders(Integer userId);
}
