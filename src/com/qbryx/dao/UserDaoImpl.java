package com.qbryx.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qbryx.dm.Customer;
import com.qbryx.dm.User;
import com.qbryx.managers.ConnectionManager;

public class UserDaoImpl implements UserDao {
	
	private static final String GET_USER = "select user_type, username, password from user where username = ?";
	private static final String GET_CUSTOMER_CART_ID = "select a.cart_id from customer_cart as a inner join user b on a.user_id = b.id where b.username = ?";

	public UserDaoImpl(){
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user = null;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			try{
				stmt = ConnectionManager.prepareStatement(GET_USER);
				stmt.setString(1, username);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
						if(rs.getInt("user_type") == 1){
							String cartId = fetchCustomerCartId(rs.getString("username"));
							user = new Customer(rs.getInt("user_type"), rs.getString("username"), rs.getString("password"), cartId);
						}else{
							user = new User(rs.getInt("user_type"), rs.getString("username"), rs.getString("password"));
						}
				}		
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	private String fetchCustomerCartId(String username){
		String cartId = "";
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(GET_CUSTOMER_CART_ID);
				stmt.setString(1,  username);
				
				ResultSet rs = stmt.executeQuery(); 
				
				if(rs.next()){
					cartId = rs.getString("cart_id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cartId;
	}
}
