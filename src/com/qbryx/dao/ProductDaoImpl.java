package com.qbryx.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbryx.domain.Category;
import com.qbryx.domain.Product;
import com.qbryx.managers.ConnectionManager;

public class ProductDaoImpl implements ProductDao {
	
	private static final String GET_ALL_PRODUCTS = "select p.upc, p.name, c.category_id, c.name, p.description, p.price  from product p inner join category c on p.category_id = c.category_id";
	private static final String GET_PRODUCT_BY_CATEGORY = "select product.upc, product.name, product.category_id, product.description, price, stock, category.name from product inner join category on product.category_id = category.category_id where category.name = ?";
	private static final String GET_PRODUCT_BY_UPC = "select upc, name, category_id, description, price, stock from product where upc = ?";
	private static final String GET_STOCK_OF_PRODUCT = "select stock from product where upc = ?";
	private static final String UPDATE_PRODUCT = "UPDATE `qbryx`.`product` SET `name` = ?, `description` = ?, `price` = ? WHERE `upc` = ?;";
	
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
					product.setCategory_id(new Category(rs.getString("category_id"), rs.getString("name")));
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
					product.setCategory_id(new Category(rs.getString("category_id"), rs.getString("name")));
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
					product.setCategory_id(new Category(rs.getString("category_id"), rs.getString("name")));
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

	@Override
	public int getStock(String upc) {
		// TODO Auto-generated method stub
		int stock = 0;
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(GET_STOCK_OF_PRODUCT);
				stmt.setString(1, upc);
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()){
					stock = rs.getInt("stock");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		ConnectionManager.closeConnection();
		return stock;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			
			try {
				stmt = ConnectionManager.prepareStatement(UPDATE_PRODUCT);
				stmt.setString(1, product.getName());
				stmt.setString(2, product.getDescription());
				stmt.setBigDecimal(3, product.getPrice());
				stmt.setString(4, product.getUpc());
				
				stmt.executeUpdate();
				System.out.println("successful");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
		ConnectionManager.closeConnection();
		return false;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
}
