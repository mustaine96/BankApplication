package com.capgemini.bankapplication.controller;

import java.io.IOException;

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
import com.capgemini.bankapplication.services.BankAccountService;
import com.capgemini.bankapplication.services.CustomerService;
import com.capgemini.bankapplication.services.impl.BankAccountServiceImpls;
import com.capgemini.bankapplication.services.impl.CustomerServiceImpls;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext context;
	private ServletConfig config;
	private CustomerService service;
       
    public ChangePassword() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
		service = new CustomerServiceImpls();
		context = config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Customer customer= (Customer) session.getAttribute("customer");
		String oldPassword= request.getParameter("oldPassword");
		String newPassword= request.getParameter("newPassword");
		
		if(service.updatePassword(customer, oldPassword, newPassword)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("custhome.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("failed.jsp");
			dispatcher.forward(request, response);
		}
			
		
	}

}
