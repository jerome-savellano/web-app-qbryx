package com.qbryx.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CartProduct extends Product {

	private int quantity;
	private Date dateAdded;

	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotal(){
		return getPrice().multiply(new BigDecimal(quantity));
	}
}
