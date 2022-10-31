package com.backymeter.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.backymeter.dao.OrderDao;
import com.backymeter.dao.impl.OrderDaoImpl;
import com.backymeter.pojo.Order;

public class OrderDaoImplTest {

	OrderDao orderDao = new OrderDaoImpl();
	
	@Test
	public void saveOrder() {
		
		System.out.println(orderDao.saveOrder(new Order("#Backymeter0000001", new Date(), new BigDecimal(999999999.99), 2, 1)));
		//System.out.println(orderDao.saveOrder(new Order("#Backymeter9999999", new Date(), new BigDecimal(999999999.99), 2, 2000)));
	}
	
	@Test
	public void queryForOrders() {
		
		System.out.println(orderDao.queryForOrders());
		
	}
	
	@Test
	public void changeStatus() {
		
		System.out.println(orderDao.changeStatus("16452820432623", 0));
		
	}
	
	@Test
	public void querySingleOrder() {
		
		System.out.println(orderDao.querySingleOrder("16452000363311"));
		
	}
	
	@Test
	public void queryUserOrders() {
		
		for(Order order : orderDao.queryUserOrders(14)) 
		System.out.println(order);
		
	}

	
}
