package com.qbryx.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qbryx.dm.Category;
import com.qbryx.dm.Customer;
import com.qbryx.dm.User;
import com.qbryx.service.LoginService;
import com.qbryx.service.LoginServiceImpl;
import com.qbryx.service.ProductService;
import com.qbryx.service.ProductServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/processLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService = new LoginServiceImpl();    
	private ProductService productService = new ProductServiceImpl();
	private static final int USER_TYPE_CUSTOMER = 1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I'm in doPost method!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		if(userName.isEmpty() || password.isEmpty()){
			boolean fieldEmpty = true;
			
			request.setAttribute("fieldEmpty", fieldEmpty);
			dispatcher("/login.jsp", request, response);
			return;
		}
		
		User user = null;

		user = loginService.getUser(userName);
		
		if(user != null && user.getPassword().equals(password)){
			if(user.getUserType() == 1){
				
				Customer customer = (Customer) user;
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				response.sendRedirect("customer");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				response.sendRedirect("home_management.jsp");
			}
		}else{
			boolean loginFailed = true;
			
			request.setAttribute("username", userName);
			request.setAttribute("loginFailed", loginFailed);
			dispatcher("/login.jsp", request, response);
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
