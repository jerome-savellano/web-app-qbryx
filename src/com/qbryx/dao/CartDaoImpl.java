package com.qbryx.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.qbryx.dm.Cart;
import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.dm.User;
import com.qbryx.managers.ConnectionManager;

public class CartDaoImpl implements CartDao {
	
	private static final String ADD_PRODUCT_IN_CART = "insert into customer_cart_items (cart_id, upc, quantity, amount, is_purchased, date_added) values (?, ?, ?, ?, ?, ?)";

	@Override
	public List<Product> getProductsInCart(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProductInCart(Cart cart) {
		boolean isSuccessful = false;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(ADD_PRODUCT_IN_CART);
				stmt.setString(1,  cart.getCartId());
				stmt.setString(2, cart.getUpc());
				stmt.setInt(3, cart.getQuantity());
				stmt.setBigDecimal(4, cart.getAmount());
				stmt.setInt(5, cart.getIsPurchased());
				stmt.setDate(6, cart.getDateAdded());
				
				stmt.executeUpdate();
				isSuccessful = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return isSuccessful;
	}

	@Override
	public boolean updateProductInCart(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductInCart(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
