package com.qbryx.service;

import java.math.BigDecimal;
import java.util.List;

import com.qbryx.dao.CartDao;
import com.qbryx.dao.CartDaoImpl;
import com.qbryx.dao.CategoryDao;
import com.qbryx.dao.CategoryDaoImpl;
import com.qbryx.dm.Cart;
import com.qbryx.dm.Category;
import com.qbryx.dm.Product;
import com.qbryx.util.CurrentDate;

public class CustomerServiceImpl implements CustomerService {
	
	CartDao cartDao;
	
	public CustomerServiceImpl(){
		this.cartDao =  new CartDaoImpl();
	}

	@Override
	public boolean addToCart(String cardId, Product product, int quantity) {
		// TODO Auto-generated method stub
		boolean isSuccessful = false;
	
		if(cardId != null || product != null){
			Cart cart = new Cart();
			
			cart.setCartId(cardId);
			cart.setUpc(product.getUpc());
			cart.setQuantity(quantity);
			cart.setAmount(computeTotalAmount(product, quantity));
			cart.setIsPurchased(0);
			cart.setDateAdded(CurrentDate.getCurrentDate());
			
			cartDao.addProductInCart(cart);
			isSuccessful = true;
		}
		
		return isSuccessful;
	}
	
	private BigDecimal computeTotalAmount(Product product, int quantity){
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		totalAmount = product.getPrice().multiply(new BigDecimal(quantity));
		
		return totalAmount;
	}
}
