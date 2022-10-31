package com.backymeter.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.backymeter.dao.FoodStuffDao;
import com.backymeter.dao.impl.FoodStuffDaoImpl;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;

public class FoodStuffDaoTest {

	FoodStuffDao foodStuffDao = new FoodStuffDaoImpl();
	
	@Test
	public void addFoodStuff() {
		foodStuffDao.addFoodStuff(new FoodStuff(null, "放下那包", new BigDecimal(9999), 188984948, 0, "", null));
	}
	
	@Test
	public void deleteFoodStuffById() {
		foodStuffDao.deleteFoodStuffById(28);
	}
	
	@Test
	public void updateFoodStuff() {
		foodStuffDao.updateFoodStuff(new FoodStuff(29, "放下那包", new BigDecimal(9999), 188984948, 1, "浮雲霎那間", null), 0);
	}
	
	@Test
	public void queryFoodStuffById() {
		System.out.println(foodStuffDao.queryFoodStuffById(29));
	}
	
	@Test
	public void queryFoodStuffs() {
		for(FoodStuff foodStuff : foodStuffDao.queryFoodStuffs()) {
			System.out.println(foodStuff);
		}
	}
	
	@Test
	public void queryPageTotalCount() {
		System.out.println(foodStuffDao.queryPageTotalCount());
	}
	
	@Test
	public void queryItems() {
		List<FoodStuff> stuffList = foodStuffDao.queryItems(3, Page.PAGE_SIZE);
		for(FoodStuff stuff:stuffList) {
			System.out.println(stuff);
		}
	}
	
	@Test
	public void getPageTotal() {
		
		System.out.println(foodStuffDao.getPageTotal(15));
		
	}
	
	@Test
	public void queryFoodStuffByPrice() {
		List<FoodStuff> list = foodStuffDao.queryFoodStuffByPrice(3, 4, 9, 15);
		for(FoodStuff stuff:list) {
			System.out.println(stuff);
		}
	}
	
	@Test
	public void getPageByPriceTotalCount() {
		System.out.println(foodStuffDao.getPageByPriceTotalCount(9, 15));
	}
	
}
