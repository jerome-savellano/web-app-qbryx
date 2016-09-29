package com.qbryx.dm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Cart {
	
	private String cartId;
	private long upc;
	private int quantity;
	private BigDecimal amount;
	private int isPurchased;
	private Date dateAdded;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public long getUpc() {
		return upc;
	}
	public void setUpc(long upc) {
		this.upc = upc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getIsPurchased() {
		return isPurchased;
	}
	public void setIsPurchased(int isPurchased) {
		this.isPurchased = isPurchased;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}