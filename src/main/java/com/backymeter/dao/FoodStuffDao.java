package com.backymeter.dao;

import java.util.List;

import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;

public interface FoodStuffDao {
	
	// 後端管理Dao
	public int addFoodStuff(FoodStuff stuff);
	
	public int deleteFoodStuffById(Integer id);
	
	public int updateFoodStuff(FoodStuff stuff, Integer preId);
	
	public FoodStuff queryFoodStuffById(Integer id);
	
	public List<FoodStuff> queryFoodStuffs();
	
	// 分頁Dao
	public int queryPageTotalCount();
	
	public List<FoodStuff> queryItems(Integer pageNo, Integer pageSize);
	
	public int getPageTotal(Integer pageSize);
	
	public List<FoodStuff> queryFoodStuffByPrice(Integer pageNo, Integer pageSize,Integer beginPrice, Integer endPrice);
	
	public int getPageByPriceTotalCount(Integer beginPrice, Integer endPrice);
	
	
	
}
