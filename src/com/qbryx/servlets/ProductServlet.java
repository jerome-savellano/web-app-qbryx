package com.qbryx.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.dm.Customer;
import com.qbryx.dm.Product;
import com.qbryx.service.CustomerService;
import com.qbryx.service.CustomerServiceImpl;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/processProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ProductService productService;
	private CustomerService customerService;
	
	private String upc = "";
	private String category = "";
	private boolean isProductAddedToCart = false;
	
    public ProductServlet() {
        super();
        productService = new ProductServiceImpl();
        customerService = new CustomerServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		if(request.getSession().getAttribute("customer") != null){
			upc = request.getParameter("upc");
			category = request.getParameter("category");
			
			request.setAttribute("product", product(upc));
			request.setAttribute("category", category);
			dispatcher("/product.jsp", request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		upc = request.getParameter("upc");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		isProductAddedToCart = customerService.addToCart(customer.getCartId(), product(upc), quantity);
		
		request.setAttribute("wasalak", isProductAddedToCart);
		doGet(request, response);
	}
	
	private RequestDispatcher dispatcher(String jsp, HttpServletRequest request, HttpServletResponse response){
		
		RequestDispatcher dispatcher = null;
		try {
			dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dispatcher;
	}
	
	private Product product(String upc){
		return productService.getProductByUpc(upc);
	}
}
