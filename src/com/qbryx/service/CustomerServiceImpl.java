package com.qbryx.service;

import java.math.BigDecimal;
import java.util.List;

import com.qbryx.dao.CartDao;
import com.qbryx.dao.CartDaoImpl;
import com.qbryx.dao.CategoryDao;
import com.qbryx.dao.CategoryDaoImpl;
import com.qbryx.dao.ProductDao;
import com.qbryx.dao.ProductDaoImpl;
import com.qbryx.domain.Cart;
import com.qbryx.domain.CartProduct;
import com.qbryx.domain.Category;
import com.qbryx.domain.Product;
import com.qbryx.util.CurrentDate;

public class CustomerServiceImpl implements CustomerService {

	private CartDao cartDao;
	private ProductDao productDao;

	public CustomerServiceImpl() {
		this.cartDao = new CartDaoImpl();
		this.productDao = new ProductDaoImpl();
	}

	@Override
	public boolean addToCart(String cardId, Product product, int quantity) {
		// TODO Auto-generated method stub
		int quantityOnHand = productDao.getStock(product.getUpc());
		
		if(cartDao.productAlreadyInCart(cardId, product.getUpc()) != null){
			Cart cart = cartDao.productAlreadyInCart(cardId, product.getUpc());
			
			if((quantity + cart.getQuantity()) <= quantityOnHand){
				cart.setQuantity(cart.getQuantity() + quantity);
				cart.setAmount(cart.getAmount().add(computeTotalAmount(product, quantity)));

				return cartDao.updateProductInCart(cart);
			}
		}else{
			if(quantity < quantityOnHand){
				Cart cart = new Cart();
				cart.setCartId(cardId);
				cart.setUpc(product.getUpc());
				cart.setQuantity(quantity);
				cart.setAmount(computeTotalAmount(product, quantity));
				cart.setIsPurchased(0);
				cart.setDateAdded(CurrentDate.getCurrentDate());

				return cartDao.addProductInCart(cart);
			}			
		}
		
		return false;
	}

	private BigDecimal computeTotalAmount(Product product, int quantity) {
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

	@Override
	public boolean removeToCart(String cartId, String upc) {
		// TODO Auto-generated method stub
		return cartDao.deleteProductInCart(cartId, upc);
	}

	@Override
	public BigDecimal getTotalAmount(String cartId) {
		// TODO Auto-generated method stub
		return cartDao.getTotalAmount(cartId);
	}
}
