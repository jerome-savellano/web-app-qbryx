package com.qbryx.dao;

import java.math.BigDecimal;
import java.util.List;

import com.qbryx.domain.Cart;
import com.qbryx.domain.CartProduct;
import com.qbryx.domain.Customer;
import com.qbryx.domain.Product;
import com.qbryx.domain.User;

public interface CartDao {
	
	List<CartProduct> getProductsInCart(String cartId);
	int getQuantityOfProductFromCart(String cartId, String upc);
	CartProduct productAlreadyInCart(String cartId, String upc);
	BigDecimal getTotalAmount(String cartId);
	
	boolean addProductInCart(CartProduct cartProduct, Cart cart);
	boolean updateProductInCart(CartProduct cartProduct, Cart cart);
	boolean deleteProductInCart(String cartId, String upc);
}
