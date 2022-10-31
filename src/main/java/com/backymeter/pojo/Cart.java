package com.backymeter.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	
	// 這個 pojo 應用不到
	// private Integer totalCount;
	// 這個 pojo 應用不到
	// private BigDecimal totalPrice;
	// 更改為Map 程式碼更簡潔
	// private List<CartItem> items = new ArrayList<CartItem>();
	// Integer=id
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	
	
	public Integer getTotalCount() {
		Integer totalCount = 0;
		if(items!=null) {
			for(Map.Entry<Integer, CartItem> entry:items.entrySet()) {
				totalCount += entry.getValue().getCount();
			}
		}
		return totalCount;
	} 
	// 此方法 不符合邏輯 因此不用
	/*public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}*/
	
	public BigDecimal getTotalPrice() {
		// 方法1
		BigDecimal totalPrice = new BigDecimal(0);
		if(items!=null) {
			for(Map.Entry<Integer, CartItem> entry:items.entrySet()) {	
				totalPrice= totalPrice.add(entry.getValue().getTotalPrice());	
			}
		}
		return totalPrice;
		// 方法2
		/*for(CartItem value : items.values()) {
			totalCount += value.getCount();
		}
		
		return totalPrice;*/
	}
	
	// 此方法 不符合邏輯 因此不用
	/*public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}*/
	
	public Map<Integer, CartItem> getItems(){
		return items;
	}
	
	public void setItems(Map<Integer, CartItem> items){
		this.items = items;
	}
	
	public String toString() {
		
		return "Cart{" +
		"totalCount=" + getTotalCount() +
		", totalPrice=" + getTotalPrice() +
		", items=" + items +
		"}";
		
	}
	
	// Cart - Functions
	public void addItem(CartItem cartItem) {
		
		CartItem item = items.get(cartItem.getId());
		if(item!=null) {
			// 更新同品項 item 數量
			item.setCount(item.getCount() + 1);
			// 更新同品項 item 價格合計
			item.setTotalPrice(BigDecimal.valueOf(item.getCount()).multiply(item.getPrice()));
			// 此非基本型別 即傳址
			//items.put(item.getId(), item);
		} else {
			
			items.put(cartItem.getId(), cartItem);
			
		}
		
	}
	
	public void deleteItem(Integer id) {
		
		items.remove(id);
		
	}
	
	public void clear() {
		
		items.clear();
		
	}
	
	public void updateCount(Integer id, Integer count) {
		
		CartItem item = items.get(id);
		if(item!=null) {
			
			item.setCount(count);
			item.setTotalPrice(BigDecimal.valueOf(item.getCount()).multiply(item.getPrice()));
			// 此為傳址 非基本型別
			//items.put(id, item);
			
		}
		 
	}
	
	public Integer getIdTotalCount() {
		
		Integer idTotalCount = null;
		
		if(items!=null) {
			
			idTotalCount = 0;
			for(CartItem item : items.values()) {	
				idTotalCount++;
			}
		}
		
		return idTotalCount;
		
	}
	
	
}
