package com.qbryx.service;

import java.math.BigDecimal;
import java.util.List;

import com.qbryx.dao.CartDao;
import com.qbryx.dao.CartDaoImpl;
import com.qbryx.dao.CategoryDao;
import com.qbryx.dao.CategoryDaoImpl;
import com.qbryx.dm.Cart;
import com.qbryx.dm.CartProduct;
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
			
			if(cartDao.productAlreadyInCart(cardId, product.getUpc()) != null){
				System.out.println("not null");
				Cart cart = cartDao.productAlreadyInCart(cardId, product.getUpc());
				cart.setQuantity(cart.getQuantity() + quantity);
				cart.setAmount(cart.getAmount().add(computeTotalAmount(product, quantity)));
				
				isSuccessful = cartDao.updateProductInCart(cart);
			}else{
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
		}
		
		return isSuccessful;
	}
	
	private BigDecimal computeTotalAmount(Product product, int quantity){
		BigDecimal totalAmount = BigDecimal.ZERO;
		
		totalAmount = product.getPrice().multiply(new BigDecimal(quantity));
		
		return totalAmount;
	}

	@Override
	public int getItemQuantityOnCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		return cartDao.getQuantityOfProductFromCart(cartId, upc);
	}

	@Override
	public List<CartProduct> getProductsOnCart(String cartId) {
		// TODO Auto-generated method stub
		return cartDao.getProductsInCart(cartId);
	}
}
