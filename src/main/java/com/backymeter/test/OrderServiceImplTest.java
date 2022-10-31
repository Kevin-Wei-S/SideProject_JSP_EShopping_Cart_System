package com.backymeter.test;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.CartItem;
import com.backymeter.pojo.Order;
import com.backymeter.pojo.OrderItem;
import com.backymeter.service.OrderService;
import com.backymeter.service.impl.OrderServiceImpl;

public class OrderServiceImplTest {

	OrderService orderService = new OrderServiceImpl();
	Cart cart = new Cart();
	
	@Test
	public void createOrder() {
		
		cart.addItem(new CartItem(101, "0217", 1, new BigDecimal(111), new BigDecimal(5661), "static/img/ready.png"));
												
		System.out.println(orderService.createOrder(cart, 1));
		
	}
	
	@Test
	public void shortageStock() {
		
		cart.addItem(new CartItem(101, "0217", 161, new BigDecimal(111), new BigDecimal(5661), "static/img/ready.png"));
		cart.addItem(new CartItem(95, "GoodJob", 38, new BigDecimal(325000000.00), new BigDecimal(325000000.00), "static/img/ready.png"));												
		cart.addItem(new CartItem(93, "Star++", 7, new BigDecimal(99999.00), new BigDecimal(99999.00), "static/img/ready.png"));
		cart.addItem(new CartItem(79, "ElegantSS+", 5, new BigDecimal(99999999.00), new BigDecimal(99999999.00), "static/img/ready.png"));
		
		Map<String, Integer> map = orderService.shortageStock(cart, 1);
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
	
			System.out.println(entry.getKey() + "=" + entry.getValue());
		
		}

	}
	
	@Test
	public void showAllOrders() {
		
		for(Order order : orderService.showAllOrders()) {
			
			System.out.println(order);
		
		}
		
	}
	
	@Test
	public void showOrderDetails() {
		
		for(OrderItem item:orderService.showOrderDetails("16451875493471"))
			System.out.println(item);
		
	}
	
	@Test
	public void getSingleOrder() {
		
		System.out.println(orderService.getSingleOrder("16451924181061")); 
		
	}
	
	@Test
	
	public void getOrderCount() {
		
		System.out.println(orderService.getOrderCount(orderService.showOrderDetails("16451909359493")));
		
	}
	
	@Test 
	public void showUserOrders() {
		
		for(Order order : orderService.showUserOrders(1))
		System.out.println(order);;
		
	}
	
	
}
