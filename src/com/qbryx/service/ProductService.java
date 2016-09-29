package com.qbryx.service;

import java.util.List;

import com.qbryx.dm.Category;
import com.qbryx.dm.Product;

public interface ProductService {

	List<Category> getCategories();
	List<Product> getProductsByCategory(String categoryName);
	
	Product getProductByUpc(String upc);
}
