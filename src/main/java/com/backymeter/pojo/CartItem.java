package com.backymeter.pojo;

import java.math.BigDecimal;

public class CartItem {
	
	private Integer id;
	private String name;
	private Integer count;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private String img_path = "static/img/ready.png";
	
	public CartItem() {
		
	}
	
	public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String img_path) {
		
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
		if(img_path!=null && !"".equals(img_path)) {
			this.img_path = img_path;
		}
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getImg_path() {
		return img_path;
	}
	
	public void setImg_path(String img_path) {
		if(img_path!=null && !"".equals(img_path)) {
			this.img_path = img_path;
		}
	}
	
	public String toString() {
		
		return "CartItem{" +
		"id=" + id +
		", name='" + name + "'" + 
		", count=" + count +
		", price=" + price +
		", totalPrice=" + totalPrice + 
		", img_path='" + img_path + "'" +
		"}";
		
	}
	
}
