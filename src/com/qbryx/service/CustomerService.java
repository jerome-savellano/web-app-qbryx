package com.qbryx.service;

import java.util.List;

import com.qbryx.dm.Category;
import com.qbryx.dm.Product;

public interface CustomerService {

	boolean addToCart(String cardId, Product product, int quantity);
	int getItemQuantityOnCart(String cardId, String upc);
}
