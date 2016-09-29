package com.qbryx.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Cart {
	
	private String cartId;
	private String upc;
	private int quantity;
	private BigDecimal amount;
	private int isPurchased;
	private Date dateAdded;
	private List<Product> productsInCart;
	
	public List<Product> getProductsInCart() {
		return productsInCart;
	}
	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
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
