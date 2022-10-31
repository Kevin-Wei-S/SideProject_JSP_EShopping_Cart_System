package com.backymeter.service.impl;

import java.util.List;

import com.backymeter.dao.FoodStuffDao;
import com.backymeter.dao.impl.FoodStuffDaoImpl;
import com.backymeter.pojo.FoodStuff;
import com.backymeter.pojo.Page;
import com.backymeter.service.FoodStuffService;

public class FoodStuffServiceImpl implements FoodStuffService {
	
	private FoodStuffDao foodStuffDao = new FoodStuffDaoImpl();
	
	public int addFoodStuff(FoodStuff stuff) {
		return foodStuffDao.addFoodStuff(stuff);
	}
	
	public void deleteFoodStuffById(Integer id) {
		foodStuffDao.deleteFoodStuffById(id);
	}
	
	public int updateFoodStuff(FoodStuff stuff, Integer id) {
		return foodStuffDao.updateFoodStuff(stuff, id);
	}
	
	public FoodStuff queryFoodStuffById(Integer id) {
		
		return foodStuffDao.queryFoodStuffById(id);
		
	}
	
	public List<FoodStuff> queryFoodStuffs(){
		
		return foodStuffDao.queryFoodStuffs();
	
	}
	
	public Page<FoodStuff> page(Integer pageNo, Integer pageSize, String url){
		
		Page<FoodStuff> page = new Page<FoodStuff>();
		
		int pageTotal = foodStuffDao.getPageTotal(pageSize);
		int pageTotalCount = foodStuffDao.queryPageTotalCount();		
		// page-Pojo setPageNo前需要有pageTotal
		page.setPageTotal(pageTotal);
		page.setPageNo(pageNo);
		// 設定分頁的數據 須獲得過濾後 有效的pageNo
		List<FoodStuff> items = foodStuffDao.queryItems(page.getPageNo(), pageSize);
		page.setPageSize(pageSize);
		page.setPageTotalCount(pageTotalCount);
		page.setItems(items);
		page.setUrl(url);
		
		return page;
	
	}
	
	public Page<FoodStuff> pageByPrice(Integer pageNo, Integer pageSize, 
									   String url, Integer beginPrice, Integer endPrice){
		
		// Page-pojo 設定 pageNo 前需要先知道 pageTotal 方能做出有效邊界判斷
		// 而獲取有效 pageNo 設定出相對的Page<FoodStuff> 
		//      之後才能應用Page<FoodStuff>裡的pageNo得到正確的items 
		// 所以順序為 pageTotal->pageNo->Page<FoodStuff>->page.getPageNo()->items 其他具彈性
		int pageByPriceTotalCount = foodStuffDao.getPageByPriceTotalCount(beginPrice, endPrice);
		int pageByPriceTotal = pageByPriceTotalCount / pageSize;
		if(pageByPriceTotalCount%pageSize>0) {
			pageByPriceTotal++;
		}
		Page<FoodStuff> page = new Page<FoodStuff>();
		page.setPageTotal(pageByPriceTotal);
		page.setPageNo(pageNo);
		// 應運有效的pageNo獲取items
		List<FoodStuff> list = foodStuffDao.queryFoodStuffByPrice(page.getPageNo(), pageSize, beginPrice, endPrice);
		page.setItems(list);
		page.setPageSize(pageSize);		
		page.setPageTotalCount(pageByPriceTotalCount);
		page.setUrl(url);
		
		return page;
	}
	
}
