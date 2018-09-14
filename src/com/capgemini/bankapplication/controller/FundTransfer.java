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
 * Servlet implementation class FundTransfer
 */
@WebServlet("/fundtransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServletContext context;
	private ServletConfig config;
	private BankAccountService service;
	
    public FundTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		
		service = new BankAccountServiceImpls();
		context = config.getServletContext();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Long custId1 = Long.parseLong(request.getParameter("custId1"));
		Double amount= Double.parseDouble(request.getParameter("amount"));
		
		HttpSession session = request.getSession();
		Customer customer= (Customer) session.getAttribute("customer");
		//System.out.println(customer.getCustId());
		if(service.fundTransfer(customer.getCustId(), custId1, amount)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("custhome.jsp");
			dispatcher.forward(request, response);
		//	System.out.println(customer.getCustAccount());
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("failed.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
