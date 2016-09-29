package com.qbryx.dao;

import java.util.List;

import com.qbryx.dm.Category;
import com.qbryx.dm.Product;

public interface ProductDao {

	List<Product> getAll();
	List<Product> getByCategory(String categoryName);
	
	Product getProductByUpc(String upc);
}
