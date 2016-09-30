package com.qbryx.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.domain.Product;
import com.qbryx.util.ServiceFactory;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub.
		String name = request.getParameter("name");
		String upc = request.getParameter("upc");
		String description = request.getParameter("description");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		if(ServiceFactory.managerService().updateProduct(product(name, description, price, stock, upc))){
			response.sendRedirect("updateSuccess.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}
	
	private Product product(String name, String desc, BigDecimal price, int stock, String upc){
		Product product = new Product();
		
		product.setName(name);
		product.setDescription(desc);
		product.setPrice(price);
		product.setStock(stock);
		product.setUpc(upc);
		
		return product;
	}

}
