package com.qbryx.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.dm.Category;
import com.qbryx.dm.Product;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();
	private boolean categorySelected = false;
	private boolean invalidOptionSelected = false;
	private String INVALID_OPTION = "SELECT CATEGORY";
	
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("categories", categories());
		dispatcher("/home_customer.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String category = request.getParameter("category");

		if(category != null){
			categorySelected = true;
			
			List<Product> products = productService.getProductsByCategory(category);
			
			request.setAttribute("products", products);
			request.setAttribute("categorySelected", categorySelected);
			request.setAttribute("categories", categories());
			request.setAttribute("category", category);
			dispatcher("/home_customer.jsp", request, response);
		}else{
			invalidOptionSelected = true;
				
			request.setAttribute("invalidOptionSelected", invalidOptionSelected);
			request.setAttribute("categories", categories());
			dispatcher("/home_customer.jsp", request, response);
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
	
	private List<Category> categories(){
		return productService.getCategories();
	}
}
