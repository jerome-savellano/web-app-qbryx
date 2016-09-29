package com.qbryx.service;

import java.util.List;

import com.qbryx.dao.CategoryDao;
import com.qbryx.dao.CategoryDaoImpl;
import com.qbryx.dao.ProductDao;
import com.qbryx.dao.ProductDaoImpl;
import com.qbryx.dm.Category;
import com.qbryx.dm.Product;

public class ProductServiceImpl implements ProductService {
	
	private CategoryDao categoryDao;
	private ProductDao productDao;
	
	public ProductServiceImpl(){
		this.categoryDao = new CategoryDaoImpl();
		this.productDao = new ProductDaoImpl();
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return productDao.getByCategory(categoryName);
	}

	@Override
	public Product getProductByUpc(long upc) {
		// TODO Auto-generated method stub
		return productDao.getProductByUpc(upc);
	}

}
