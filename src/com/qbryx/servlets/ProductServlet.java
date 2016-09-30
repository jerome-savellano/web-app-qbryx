package com.qbryx.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.domain.Customer;
import com.qbryx.domain.Product;
import com.qbryx.service.CustomerService;
import com.qbryx.service.CustomerServiceImpl;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;
import com.qbryx.util.ServiceFactory;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/processProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
	private String upc = "";
	private String category = "";
	private boolean isProductAddedToCart = false;
	
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = (Customer) request.getSession().getAttribute("customer");
				
		if(request.getSession().getAttribute("customer") != null){
			upc = request.getParameter("upc");
			category = request.getParameter("category");
			
			request.setAttribute("product", ServiceFactory.productService().getProductByUpc(upc));
			request.setAttribute("quantity", ServiceFactory.customerService().getItemQuantityOnCart(customer.getCartId(), upc));
			request.setAttribute("category", category);
			dispatcher("/product.jsp", request, response);
		}else{
			upc = request.getParameter("upc");
			category = request.getParameter("category");
			
			request.setAttribute("product", ServiceFactory.productService().getProductByUpc(upc));
			request.setAttribute("category", category);
			dispatcher("/manageProducts.jsp", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("customer") != null){
			Customer customer = (Customer) request.getSession().getAttribute("customer");
			
			Product product = ServiceFactory.productService().getProductByUpc(request.getParameter("upc"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			boolean addToCartSuccessful = ServiceFactory.customerService().addToCart(customer.getCartId(), product, quantity);
			
			if(addToCartSuccessful){
				response.sendRedirect("addedToCart.jsp");
			}else{
				response.sendRedirect("error.jsp");
			}
			
		}else{
			response.sendRedirect("login.jsp");
		}
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
}
