package com.qbryx.dao;

import java.util.List;

import com.qbryx.dm.Cart;
import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.dm.User;

public interface CartDao {
	
	List<Product> getProductsInCart(Customer customer);
	
	boolean addProductInCart(Cart cart);
	boolean updateProductInCart(Product product);
	boolean deleteProductInCart(Product product);
}
