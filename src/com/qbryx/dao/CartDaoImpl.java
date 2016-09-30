package com.qbryx.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbryx.domain.Cart;
import com.qbryx.domain.CartProduct;
import com.qbryx.domain.Customer;
import com.qbryx.domain.Product;
import com.qbryx.managers.ConnectionManager;

public class CartDaoImpl implements CartDao {
	
	private static final String ADD_PRODUCT_IN_CART = "insert into customer_cart_items (cart_id, upc, quantity, amount, is_purchased, date_added) values (?, ?, ?, ?, ?, ?)";
	private static final String GET_QUANTITY_PRODUCT_FROM_CART = "select quantity from customer_cart_items where cart_id = ? and upc = ?";
	private static final String GET_PRODUCT_FROM_CART = "select cart_id, upc, quantity, amount, is_purchased, date_added from customer_cart_items where cart_id = ? and upc = ?";
	private static final String GET_PRODUCTS_FROM_CART = "select p.name, p.upc, c.amount, c.quantity, c.date_added from customer_cart_items as c inner join product as p on c.upc = p.upc where c.cart_id = ?";
	private static final String UPDATE_PRODUCT_IN_CART = "UPDATE `qbryx`.`customer_cart_items` SET `upc` = ?, `quantity` = ?, `amount` = ?, `is_purchased` = ?, `date_added` = ? WHERE `cart_id` = ? and `upc` = ?";
	private static final String DELETE_PRODUCT_IN_CART = "delete from customer_cart_items where cart_id = ? and upc = ?";
	private static final String GET_TOTAL_AMOUNT = "select sum(amount) as total_amount from customer_cart_items where cart_id = ?";
	
	@Override
	public List<CartProduct> getProductsInCart(String cartId) {
		// TODO Auto-generated method stub
		List<CartProduct> cartProducts = new ArrayList<>();
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
				
			try {
				stmt = ConnectionManager.prepareStatement(GET_PRODUCTS_FROM_CART);
				stmt.setString(1, cartId);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					CartProduct cartProduct = new CartProduct();
					
					cartProduct.setName(rs.getString("name"));
					cartProduct.setUpc(rs.getString("upc"));
					cartProduct.setQuantity(rs.getInt("quantity"));
					cartProduct.setDateAdded(rs.getDate("date_added"));
					
					cartProducts.add(cartProduct);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			}
		}
		
		ConnectionManager.closeConnection();
		return cartProducts;
	}

	@Override
	public boolean addProductInCart(CartProduct cartProduct, Cart cart) {
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(ADD_PRODUCT_IN_CART);
				stmt.setString(1,  cart.getCartId());
				stmt.setString(2, cartProduct.getUpc());
				stmt.setInt(3, cartProduct.getQuantity());
				stmt.setBigDecimal(4, cartProduct.getTotal());
				
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
	public boolean updateProductInCart(CartProduct cartProduct, Cart cart) {
		// TODO Auto-generated method stub
		if(cart != null && ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			stmt = ConnectionManager.prepareStatement(UPDATE_PRODUCT_IN_CART);
			try {
				stmt.setString(1, cartProduct.getUpc());
				stmt.setInt(2, cartProduct.getQuantity());
				stmt.setBigDecimal(3, cartProduct.getTotal());
				
				stmt.setString(6, cart.getCartId());
				stmt.setString(7, cartProduct.getUpc());
				
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
	public CartProduct productAlreadyInCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		CartProduct cart = null;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
				
			try {
				stmt = ConnectionManager.prepareStatement(GET_PRODUCT_FROM_CART);
				stmt.setString(1, cartId);
				stmt.setString(2, upc);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					cart = new CartProduct();
					cart.setQuantity(rs.getInt("quantity"));
					cart.setUpc(rs.getString("upc"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ConnectionManager.closeConnection();
		return cart;
	}

	@Override
	public boolean deleteProductInCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(DELETE_PRODUCT_IN_CART);
				stmt.setString(1, cartId);
				stmt.setString(2, upc);
				
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
	public BigDecimal getTotalAmount(String cartId) {
		// TODO Auto-generated method stub
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			try {
				stmt = ConnectionManager.prepareStatement(GET_TOTAL_AMOUNT);
				stmt.setString(1, cartId);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					totalAmount = rs.getBigDecimal("total_amount");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		ConnectionManager.closeConnection();
		return totalAmount;
	}
}
