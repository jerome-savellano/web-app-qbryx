package com.qbryx.domain;

import java.math.BigDecimal;

public class Product {
	
	private String upc;
	private Category category_id;
	private String name; 
	private String description; 
	private BigDecimal price;
	
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public Category getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product() {
		super();
	}
	
	public Product(String upc, String name, String description, BigDecimal price) {
		super();
		this.upc = upc;
		this.name = name;
		this.description = description;
		this.price = price;
	}
}
