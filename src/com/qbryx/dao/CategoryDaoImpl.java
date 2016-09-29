package com.qbryx.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qbryx.dm.Category;
import com.qbryx.managers.ConnectionManager;

public class CategoryDaoImpl implements CategoryDao {

	public CategoryDaoImpl(){
	}
	
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<>();
		
		if(ConnectionManager.getConnection() != null){
			PreparedStatement stmt;
			
			try{
				stmt = ConnectionManager.prepareStatement("select category_id, name from category");
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					categories.add(new Category(rs.getString("category_id"), rs.getString("name")));
				}
			}catch(SQLException e){
				System.out.println("something's wrong");
				System.out.println(e.getMessage());
			}
		}
	
		ConnectionManager.closeConnection();
		return categories;
	}

}
