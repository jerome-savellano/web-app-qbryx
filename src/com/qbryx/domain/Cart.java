package com.qbryx.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Cart {
	
	private String cartId;
	private List<CartProduct> productsInCart;
	
	public List<CartProduct> getProductsInCart() {
		return productsInCart;
	}
	public void setProductsInCart(List<CartProduct> productsInCart) {
		this.productsInCart = productsInCart;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
}
