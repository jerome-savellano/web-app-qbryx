package com.qbryx.service;

import java.math.BigDecimal;
import java.util.List;

import com.qbryx.domain.CartProduct;
import com.qbryx.domain.Category;
import com.qbryx.domain.Product;

public interface CustomerService {

	boolean addToCart(String cardId, Product product, int quantity);
	boolean removeToCart(String cartId, String upc);
	int getItemQuantityOnCart(String cardId, String upc);
	List<CartProduct> getProductsOnCart(String cartId);
	BigDecimal getTotalAmount(String cartId);
}
