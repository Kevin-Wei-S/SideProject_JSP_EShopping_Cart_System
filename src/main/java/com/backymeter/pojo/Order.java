package com.backymeter.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	
	private String order_id;
	// 引用java.util
	private Date create_time;
	private BigDecimal price;
	// 0未出貨, 1已出貨, 2表示已簽收
	private Integer status = 0;
	private Integer user_id;

	public Order() {
		
	}

	public Order(String order_id, Date create_time, BigDecimal price, Integer status, Integer user_id) {
		
		this.order_id = order_id;
		this.create_time = create_time;
		this.price = price;
		this.status = status;
		this.user_id = user_id;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", create_time=" + create_time + ", price=" + price + ", status="
				+ status + ", user_id=" + user_id + "]";
	}

	
}
