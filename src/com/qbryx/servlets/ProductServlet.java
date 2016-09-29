package com.qbryx.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.dm.Product;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/viewProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ProductService productService = new ProductServiceImpl();
	
	private String upc = "";
	private String category = "";
	
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("username") != null){
			upc = request.getParameter("action");
			category = request.getParameter("category");
			
			Product product = productService.getProductByUpc(Long.parseLong(upc));
			
			request.setAttribute("product", product);
			request.setAttribute("category", category);
			dispatcher("/product.jsp", request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
}
