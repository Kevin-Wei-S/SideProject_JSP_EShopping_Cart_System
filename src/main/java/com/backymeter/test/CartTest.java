package com.backymeter.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.backymeter.pojo.Cart;
import com.backymeter.pojo.CartItem;

public class CartTest {
	
	Cart cart = new Cart();
	
	@Test
	public void addItem() {
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		for(int i=0 ; i<=13 ;i++) {
			cart.addItem(new CartItem(i, "Sky"+i, i, new BigDecimal(99999), new BigDecimal(99999).multiply(new BigDecimal(i)), "img_path"));
			if(i==13)
			System.out.println(cart);
		}
	}
	
	@Test
	public void deleteItem() {
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		for(int i=0 ; i<=13 ;i++) {
			cart.addItem(new CartItem(i, "Sky"+i, i, new BigDecimal(99999), new BigDecimal(99999).multiply(new BigDecimal(i)), "img_path"));
			if(i==13)
			System.out.println(cart);
		}
		cart.deleteItem(1);
		System.out.println(cart);
	}
	
	@Test
	public void clear() {
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		for(int i=0 ; i<=13 ;i++) {
			cart.addItem(new CartItem(i, "Sky"+i, i, new BigDecimal(99999), new BigDecimal(99999).multiply(new BigDecimal(i)), "img_path"));
			if(i==13)
			System.out.println(cart);
		}
		cart.deleteItem(1);
		System.out.println(cart);
	
		cart.clear();
		System.out.println(cart);
	}
	
	@Test
	public void updateCount() {
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		for(int i=0 ; i<=13 ;i++) {
			cart.addItem(new CartItem(i, "Sky"+i, i, new BigDecimal(99999), new BigDecimal(99999).multiply(new BigDecimal(i)), "img_path"));
			if(i==13)
			System.out.println(cart);
		}
		cart.deleteItem(1);
		System.out.println(cart);
	
		cart.clear();
		System.out.println(cart);
		
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		cart.updateCount(1, 10);
		System.out.println(cart);
		
	}
	
	@Test
	public void getIdTotalCount() {
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		for(int i=0 ; i<=13 ;i++) {
			cart.addItem(new CartItem(i, "Sky"+i, i, new BigDecimal(99999), new BigDecimal(99999).multiply(new BigDecimal(i)), "img_path"));
			if(i==13)
			System.out.println(cart);
		}
		cart.deleteItem(1);
		cart.clear();
		cart.addItem(new CartItem(1, "Sky"+1, 1, new BigDecimal(99999), new BigDecimal(99999), "img_path"));
		cart.updateCount(1, 10);
		System.out.println(cart.getIdTotalCount());
		
	}
	
}
