package com.qbryx.dao;

import java.util.List;

import com.qbryx.domain.Category;
import com.qbryx.domain.Product;

public interface ProductDao {

	List<Product> getAll();
	List<Product> getByCategory(String categoryName);
	
	Product getProductByUpc(String upc);
	int getStock(String upc);
	
	boolean updateProduct(Product product);
	boolean addProduct(Product product);
}
