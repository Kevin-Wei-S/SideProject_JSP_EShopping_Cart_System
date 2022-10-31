package com.backymeter.dao.impl;

import java.util.List;

import com.backymeter.dao.BaseDao;
import com.backymeter.dao.OrderDao;
import com.backymeter.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	
	public int saveOrder(Order order) {
		
		String sql = "insert into t_order values(?, ?, ?, ?, ?)";
		
		return update(sql, order.getOrder_id(), order.getCreate_time(), order.getPrice(), 
			   order.getStatus(), order.getUser_id());
	}
	

	public List<Order> queryForOrders() {
		
		String sql = "select * from t_order";
		
		return queryForList(Order.class, sql);
		
	}
	
	public int changeStatus(String orderId, Integer status) {
		
		String sql = "update t_order set status=? where order_id = ?";
		
		return update(sql, status, orderId);
		

	}
	
	public Order querySingleOrder(String orderId) {
		
		String sql = "select * from t_order where order_id = ?";
		
		return queryForOne(Order.class, sql, orderId);
		
	}
	
	public List<Order> queryUserOrders(Integer userId) {
		
		String sql = "select * from t_order where user_id = ?";		
		
		return queryForList(Order.class, sql, userId);
		
	}
	
}
