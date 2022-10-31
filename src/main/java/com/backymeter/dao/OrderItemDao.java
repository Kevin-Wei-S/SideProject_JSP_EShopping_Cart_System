package com.backymeter.dao;

import java.util.List;

import com.backymeter.pojo.OrderItem;

public interface OrderItemDao {

	public int saveOrderItem(OrderItem orderItem);
	
	public List<OrderItem> queryOrderItems(String orderId);
	
}
