package com.qbryx.dao;

import java.util.List;

import com.qbryx.dm.Cart;
import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.dm.User;

public interface CartDao {
	
	List<Product> getProductsInCart(Customer customer);
	int getQuantityOfProductFromCart(String cartId, String upc);
	
	Cart productAlreadyInCart(String cartId, String upc);
	
	boolean addProductInCart(Cart cart);
	boolean updateProductInCart(Cart cart);
	boolean deleteProductInCart(Product product);
}
