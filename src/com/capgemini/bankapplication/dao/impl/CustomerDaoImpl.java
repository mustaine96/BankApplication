package com.capgemini.bankapplication.dao.impl;

import java.util.Set;

import com.capgemini.bankapplication.dao.CustomerDao;
import com.capgemini.bankapplication.dummydatabase.DummyDatabase;
import com.capgemini.bankapplication.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public Customer authenticate(Customer customer) {
		DummyDatabase data = new DummyDatabase();
		System.out.println("Hello1");
		Set<Customer> customers = DummyDatabase.getCustomers();
		
		for(Customer customer1: DummyDatabase.getCustomers()) {
			if(customer1.getCustId() == customer.getCustId()) {
				System.out.println("Hello2");
				if(customer1.getCustPassword().equals(customer.getCustPassword())) {
					System.out.println("Hello");
					return customer1;
				}
				else {
					return customer;
				}
			}
		}
		return null;
	}

	@Override
	public Customer updateProfile(Customer customer) {
		
		Set<Customer> customers = DummyDatabase.getCustomers();
		for(Customer customer1: customers) {
			if(customer1.getCustId() == customer.getCustId()) {
				customer1.setCustAddress(customer.getCustAddress());
				customer1.setCustEmail(customer.getCustEmail());
				customer1.setCustDob(customer.getCustDob());
				customer1.setCustName(customer.getCustName());
			}
			
		}
		
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {

		Set<Customer> customers = DummyDatabase.getCustomers();
		for(Customer customer1: customers) {
			if(customer1.getCustId() == customer.getCustId() && customer1.getCustPassword().equals(oldPassword)) {
				
				customer1.setCustPassword(newPassword);
				return true;
			}
		}
		
		return false;
	}
	

}
