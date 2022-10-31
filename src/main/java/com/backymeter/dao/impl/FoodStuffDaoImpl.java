package com.backymeter.dao.impl;

import java.util.List;

import com.backymeter.dao.BaseDao;
import com.backymeter.dao.FoodStuffDao;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;
import com.backymeter.utils.WebUtils;

public class FoodStuffDaoImpl extends BaseDao implements FoodStuffDao {
	
	public int addFoodStuff(FoodStuff stuff) {
		
		String sql = "insert into foodstuff values(null, ?, ?, ?, ?, ?, ?)";
		
		return update(sql, stuff.getName(), stuff.getPrice(), 
					  stuff.getSales(), stuff.getStock(), 
					  stuff.getIngredient(), stuff.getImg_path());
	}
	
	public int deleteFoodStuffById(Integer id) {
		
		String sql = "delete from foodstuff where id=?";
		
		return update(sql, id);
	}
	
	public int updateFoodStuff(FoodStuff stuff, Integer preId) {
		
		String sql = "update foodstuff set id=?, name=?, price=?, sales=?,"
				   + "stock=?, ingredient=?, img_path=? where id=?";
		
		return update(sql, stuff.getId(), stuff.getName(), stuff.getPrice(), stuff.getSales(),
					  stuff.getStock(), stuff.getIngredient(), stuff.getImg_path(), preId
					  );
	}
	
	public FoodStuff queryFoodStuffById(Integer id) {
		
		String sql = "select * from foodstuff where id = ?";
		
		return queryForOne(FoodStuff.class, sql, id);
	}
	
	public List<FoodStuff> queryFoodStuffs(){
		
		String sql = "select * from foodstuff";
		
		return queryForList(FoodStuff.class, sql);
	}
	
	public int queryPageTotalCount() {
		
		String sql = "select count(*) from foodstuff";
		
		return ((Long)queryForSingleValue(sql)).intValue();
	
	}
	
	public List<FoodStuff> queryItems(Integer pageNo, Integer pageSize){
		
		String sql = "select * from foodstuff limit ?, ?";
		Integer dataNo = (pageNo-1) * pageSize;
	
		return queryForList(FoodStuff.class, sql, dataNo, pageSize);
		
	}
	
	// 照理說與Dao無關不該寫在這 下次記得
	public int getPageTotal(Integer pageSize) {
		
		int pageTotal = queryPageTotalCount() / pageSize;
		
		if(queryPageTotalCount()%pageSize>0) {
			pageTotal++; 
		}
		return pageTotal;
	}
	
	public List<FoodStuff> queryFoodStuffByPrice(Integer pageNo, Integer pageSize, Integer beginPrice, Integer endPrice){
		
		String sql = "select * from foodstuff where price between ? and ? order by price limit ?, ? ";
		
		int begin = (pageNo - 1) * pageSize;
		
		return queryForList(FoodStuff.class, sql, beginPrice, endPrice, begin, pageSize);
	
	}
	
	public int getPageByPriceTotalCount(Integer beginPrice, Integer endPrice) {
		
		String sql = "select count(*) from foodstuff where ?<=price and price<=?";
		
		return ((Long)queryForSingleValue(sql, beginPrice, endPrice)).intValue();
		
	}
	 
}
