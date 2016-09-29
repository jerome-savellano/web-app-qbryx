package com.qbryx.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qbryx.dm.Cart;
import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.dm.User;
import com.qbryx.managers.ConnectionManager;

public class CartDaoImpl implements CartDao {
	
	private static final String ADD_PRODUCT_IN_CART = "insert into customer_cart_items (cart_id, upc, quantity, amount, is_purchased, date_added) values (?, ?, ?, ?, ?, ?)";
	private static final String GET_QUANTITY_PRODUCT_FROM_CART = "select quantity from customer_cart_items where cart_id = ? and upc = ?";
	private static final String GET_PRODUCT_FROM_CART = "select cart_id, upc, quantity, amount, is_purchased, date_added from customer_cart_items where cart_id = ? and upc = ?";
	private static final String UPDATE_PRODUCT_IN_CART = "UPDATE `qbryx`.`customer_cart_items` SET `upc` = ?, `quantity` = ?, `amount` = ?, `is_purchased` = ?, `date_added` = ? WHERE `cart_id` = ?";
	
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
		
		ConnectionManager.closeConnection();
		return isSuccessful;
	}

	@Override
	public boolean updateProductInCart(Cart cart) {
		// TODO Auto-generated method stub
		if(cart != null && ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			stmt = ConnectionManager.prepareStatement(UPDATE_PRODUCT_IN_CART);
			try {
				stmt.setString(1, cart.getUpc());
				stmt.setInt(2, cart.getQuantity());
				stmt.setBigDecimal(3, cart.getAmount());
				stmt.setInt(4, cart.getIsPurchased());
				stmt.setDate(5, cart.getDateAdded());
				stmt.setString(6, cart.getCartId());
				
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		ConnectionManager.closeConnection();
		return false;
	}

	@Override
	public boolean deleteProductInCart(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQuantityOfProductFromCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		int quantity = 0;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
				
			try {
				stmt = ConnectionManager.prepareStatement(GET_QUANTITY_PRODUCT_FROM_CART);
				stmt.setString(1, cartId);
				stmt.setString(2, upc);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					quantity = rs.getInt("quantity");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ConnectionManager.closeConnection();
		return quantity;
	}

	@Override
	public Cart productAlreadyInCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		Cart cart = null;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
				
			try {
				stmt = ConnectionManager.prepareStatement(GET_PRODUCT_FROM_CART);
				stmt.setString(1, cartId);
				stmt.setString(2, upc);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					cart = new Cart();
					cart.setCartId(rs.getString("cart_id"));
					cart.setAmount(rs.getBigDecimal("amount"));
					cart.setUpc(rs.getString("upc"));
					cart.setIsPurchased(rs.getInt("is_purchased"));
					cart.setQuantity(rs.getInt("quantity"));
					cart.setDateAdded(rs.getDate("date_added"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ConnectionManager.closeConnection();
		return cart;
	}

}
