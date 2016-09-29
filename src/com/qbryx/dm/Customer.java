package com.qbryx.dm;

public class Customer extends User {
	
	private String cartId;
	
	public Customer(int user_type, String username, String password, String cartId) {
		super(user_type, username, password);
		// TODO Auto-generated constructor stub
		this.cartId = cartId;
	}

	

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cart_id) {
		this.cartId = cart_id;
	}
}
