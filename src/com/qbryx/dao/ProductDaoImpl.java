package com.qbryx.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbryx.dm.Category;
import com.qbryx.dm.Product;
import com.qbryx.managers.ConnectionManager;

public class ProductDaoImpl implements ProductDao {
	
	private static final String GET_ALL_PRODUCTS = "select upc, name, category_id, description  from product";
	private static final String GET_PRODUCT_BY_CATEGORY = "select product.upc, product.name, product.category_id, product.description, price from product inner join category on product.category_id = category.category_id where category.name = ?";
	private static final String GET_PRODUCT_BY_UPC = "select upc, name, category_id, description, price from product where upc = ?";
	
	public ProductDaoImpl(){}
	
	@Override
	public List<Product> getAll() {
		
		List<Product> products = null;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			try {
				stmt = ConnectionManager.prepareStatement(GET_ALL_PRODUCTS);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					Product product = new Product();
					
					product.setUpc(rs.getString("upc"));
					product.setName(rs.getString("name"));
					product.setCategory_id(rs.getString("category_id"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getBigDecimal("price"));
					
					products.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		ConnectionManager.closeConnection();
		return products;
	}

	@Override
	public List<Product> getByCategory(String categoryName) {
		
		List<Product> products = new ArrayList<>();
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
		
			try {
				stmt = ConnectionManager.prepareStatement(GET_PRODUCT_BY_CATEGORY);
				stmt.setString(1,  categoryName);;
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					Product product = new Product();
					
					product.setUpc(rs.getString("upc"));
					product.setName(rs.getString("name"));
					product.setCategory_id(rs.getString("category_id"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getBigDecimal("price"));
					
					
					products.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		ConnectionManager.closeConnection();
		return products;
	}

	@Override
	public Product getProductByUpc(String upc) {
		// TODO Auto-generated method stub
		Product product = null;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(GET_PRODUCT_BY_UPC);
				stmt.setString(1,  upc);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					product = new Product();
					product.setUpc(rs.getString("upc"));
					product.setName(rs.getString("name"));
					product.setCategory_id(rs.getString("category_id"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getBigDecimal("price"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ConnectionManager.closeConnection();
		return product;
	}
}
