package com.qbryx.util;

import com.qbryx.service.CustomerService;
import com.qbryx.service.CustomerServiceImpl;
import com.qbryx.service.ManagerService;
import com.qbryx.service.ManagerServiceImpl;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;

public class ServiceFactory {
	
	private static CustomerService customerService = new CustomerServiceImpl();
	
	public static CustomerService customerService(){
		return customerService;
	}

	public static ProductService productService(){
		return new ProductServiceImpl();
	}
	
	public static ManagerService managerService(){
		return new ManagerServiceImpl();
	}
}
