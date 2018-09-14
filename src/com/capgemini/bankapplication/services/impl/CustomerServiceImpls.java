package com.capgemini.bankapplication.services.impl;

import com.capgemini.bankapplication.dao.CustomerDao;
import com.capgemini.bankapplication.dao.impl.CustomerDaoImpl;
import com.capgemini.bankapplication.model.Customer;
import com.capgemini.bankapplication.services.CustomerService;

public class CustomerServiceImpls implements CustomerService {
	
	private CustomerDao customerDao; 
	

	public CustomerServiceImpls() {
		super();
		customerDao=new CustomerDaoImpl();
	}

	@Override
	public Customer authenticate(Customer customer) {
		return customerDao.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerDao.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		
		return customerDao.updatePassword(customer, oldPassword, newPassword);
	}

}
