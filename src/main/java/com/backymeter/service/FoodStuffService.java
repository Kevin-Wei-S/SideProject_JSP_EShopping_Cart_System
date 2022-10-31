package com.backymeter.service;

import java.util.List;

import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;

public interface FoodStuffService {
	
	public int addFoodStuff(FoodStuff stuff);
	
	public void deleteFoodStuffById(Integer id);
	
	public int updateFoodStuff(FoodStuff stuff, Integer id);
	
	public FoodStuff queryFoodStuffById(Integer id);
	
	public List<FoodStuff> queryFoodStuffs();

	public Page<FoodStuff> page(Integer pageNo, Integer pageSize, String url);
	
	public Page<FoodStuff> pageByPrice(Integer pageNo, Integer pageSize,
									   String url, Integer beginPrice, Integer endPrice);

}
