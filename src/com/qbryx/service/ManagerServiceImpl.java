package com.qbryx.service;

import com.qbryx.dao.ProductDao;
import com.qbryx.dao.ProductDaoImpl;
import com.qbryx.domain.Product;

public class ManagerServiceImpl implements ManagerService {
	
	private ProductDao productDao;
	
	public ManagerServiceImpl(){
		this.productDao = new ProductDaoImpl();
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

}
