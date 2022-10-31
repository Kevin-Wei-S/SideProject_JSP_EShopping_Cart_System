package com.backymeter.dao.impl;

import java.util.List;

import com.backymeter.dao.BaseDao;
import com.backymeter.dao.OrderItemDao;
import com.backymeter.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	public int saveOrderItem(OrderItem orderItem) {
		
		String sql = "insert into t_order_item values(?, ?, ?, ?, ?, ?)";
		
		return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(), 
			   orderItem.getPrice(), orderItem.getTotal_price(), orderItem.getOrder_id());
		
	}
	
	public List<OrderItem> queryOrderItems(String orderId) {
		
		String sql = "select * from t_order_item where order_id = ?";
		
		return queryForList(OrderItem.class, sql, orderId);
		
	}
	
}
