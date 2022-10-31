package com.backymeter.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.backymeter.dao.OrderItemDao;
import com.backymeter.dao.impl.OrderItemDaoImpl;
import com.backymeter.pojo.OrderItem;

public class OrderItemDaoImplTest {
	
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Test
	public void saveOrderItem() {
		
		//System.out.println(orderItemDao.saveOrderItem(new OrderItem(null, "蹲馬馬包", 1, new BigDecimal(999999999.99), 
								  //new BigDecimal(999999999.99), "rewrewr3443")));
		System.out.println(orderItemDao.saveOrderItem(new OrderItem(null, "蹲馬馬包", 1, new BigDecimal(999999999.99), 
				   new BigDecimal(999999999.99), "#Backymeter0000001")));
		
	}
	
	@Test
	public void queryOrderItems() {
		for(OrderItem item:orderItemDao.queryOrderItems("16451875493471"))
		System.out.println(item);
		
	}
	
}
