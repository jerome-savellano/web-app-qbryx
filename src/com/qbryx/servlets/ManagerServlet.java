package com.qbryx.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.domain.Category;
import com.qbryx.domain.Product;
import com.qbryx.util.ServiceFactory;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/management")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	boolean categorySelected = false;
	public ManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("categories", ServiceFactory.productService().getCategories());
		dispatcher("/home_management.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		
		categorySelected = true;			
		List<Product> products = ServiceFactory.productService().getProductsByCategory(category);
		
		request.setAttribute("products", products);
		request.setAttribute("categorySelected", categorySelected);
		request.setAttribute("categories", ServiceFactory.productService().getCategories());
		request.setAttribute("category", category);
		dispatcher("/home_management.jsp", request, response);
	}

	private RequestDispatcher dispatcher(String jsp, HttpServletRequest request, HttpServletResponse response) {

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
