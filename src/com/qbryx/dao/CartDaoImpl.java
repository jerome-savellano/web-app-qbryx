package com.qbryx.dao;

import java.util.List;

import com.qbryx.dm.Cart;
import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.dm.User;

public class CartDaoImpl implements CartDao {

	@Override
	public List<Product> getProductsInCart(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProductInCart(Cart cart) {
		boolean isSuccessful = false;
		
		
		
		return isSuccessful;
	}

	@Override
	public boolean updateProductInCart(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductInCart(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
