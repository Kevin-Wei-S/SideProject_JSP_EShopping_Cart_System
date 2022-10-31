package com.backymeter.pojo;

import java.math.BigDecimal;

public class FoodStuff {

	private Integer id;
	private String name;
	private BigDecimal price;
	private Integer sales;
	private Integer stock;
	private String ingredient;
	private String img_path = "static/img/ready.png";
	
	public FoodStuff(Integer id, String name, BigDecimal price, Integer sales, 
					 Integer stock, String ingredient, String img_path) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.ingredient = ingredient;
		if(img_path != null && !"".equals(img_path)) {
			this.img_path = img_path;
		}
		
		
	}
	
	public FoodStuff() {
		
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
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getSales() {
		return sales;
	}
	
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	public String getImg_path() {
		return img_path;
	}
	
	public void setImg_path(String img_path) {
		if(img_path != null && !"".equals(img_path)) {
			this.img_path = img_path;
		}
		
	}
	
	public String toString() {
		return "FoodStuff{" +
			   "id=" + id +
			   ", name='" + name + "'" +
			   ", price=" + price +
			   ", sales=" + sales + 
			   ", stock=" + stock + 
			   ", ingredient='" + ingredient + "'" +
			   ", img_path='" + img_path + "'" +
			   "}";
	}
	
}
