package com.capgemini.bankapplication.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapplication.model.Customer;
import com.capgemini.bankapplication.services.CustomerService;
import com.capgemini.bankapplication.services.impl.CustomerServiceImpls;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext context;
	private ServletConfig config;
	private CustomerService service;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		service = new CustomerServiceImpls();
		context = config.getServletContext();
		
	}
       
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String custId = request.getParameter("custId");
		String custPassword = request.getParameter("custPassword");
		
		Customer customer = new Customer(Integer.parseInt(custId), null, custPassword, null, null, LocalDate.now(), null);
		System.out.println(customer);
		System.out.println(service.authenticate(customer));
		if(service.authenticate(customer) != null) {
			System.out.println("Hello");
			
			HttpSession session = request.getSession();
			session.setAttribute("customer", service.authenticate(customer));
			//response.sendRedirect("account");
			RequestDispatcher dispatcher = request.getRequestDispatcher("custhome.jsp");
			dispatcher.forward(request, response);
			
			
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
