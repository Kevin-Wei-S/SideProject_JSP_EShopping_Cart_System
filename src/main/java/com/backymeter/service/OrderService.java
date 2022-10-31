package com.backymeter.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.Order;
import com.backymeter.pojo.OrderItem;

public interface OrderService {
	
	// 返回-訂單號
	public String createOrder(Cart cart, Integer userId);
	// 返回-庫存不足數據
	public Map<String, Integer> shortageStock(Cart cart, Integer userId);
	// 管理員-查詢所有訂單
	public List<Order> showAllOrders();
	// 管理員-更改訂單運送狀態
	public void sendOrder(String orderId, Integer status);
	// 返回-訂單編號內含品項
	public List<OrderItem> showOrderDetails(String OrderId);
	// 返回-單筆訂單
	public Order getSingleOrder(String orderId);
	// 返回-單筆訂單項目總單位數
	public int getOrderCount(List<OrderItem> list);
	// 使用者-查詢使用者所有訂單
	public List<Order> showUserOrders(Integer userId);


}
