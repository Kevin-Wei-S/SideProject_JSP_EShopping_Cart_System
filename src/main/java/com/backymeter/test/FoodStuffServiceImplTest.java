package com.backymeter.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;
import com.backymeter.service.FoodStuffService;
import com.backymeter.service.impl.FoodStuffServiceImpl;

public class FoodStuffServiceImplTest {
	
	private FoodStuffService foodStuffService = new FoodStuffServiceImpl();
	
	@Test
	public void addFoodStuff() {
		foodStuffService.addFoodStuff(new FoodStuff(null, "四神八寶包掉漆版", new BigDecimal(200), 5001, 100000, "麵點王奧義", null));
	}
	
	@Test
	public void deleteFoodStuffById() {
		foodStuffService.deleteFoodStuffById(33);
	}
	
	@Test
	public void updateFoodStuff() {
		foodStuffService.updateFoodStuff(new FoodStuff(32, "四神八寶包補漆版", new BigDecimal(5200), 125001, 500, "麵點王補漆奧義", null), 0);
	}
	
	@Test
	public void queryFoodStuffById() {
		System.out.println(foodStuffService.queryFoodStuffById(29));
	}
	
	@Test
	public void queryFoodStuffs() {
		for(FoodStuff stuff:foodStuffService.queryFoodStuffs()) {
			System.out.println(stuff);
		}
	}
	
	@Test
	public void page() {
		System.out.println(foodStuffService.page(1, 13, null));
	}
	
	@Test
	public void pageByPrice(){
		System.out.println(foodStuffService.pageByPrice(1, 8, null, 8, 15));
	}
	
	@Test
	public void test() {
		
		Long unique = System.currentTimeMillis();
		
		System.out.println(unique + 33);
		System.out.println(unique + "" + 33);
		System.out.println(String.format("%d", unique));
	}
	
	
}
