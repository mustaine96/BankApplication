package com.capgemini.bankapplication.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

import com.capgemini.bankapplication.dao.CustomerDao;
import com.capgemini.bankapplication.database.DbUtil;
import com.capgemini.bankapplication.dummydatabase.DummyDatabase;
import com.capgemini.bankapplication.model.BankAccount;
import com.capgemini.bankapplication.model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	

	@Override
	public Customer authenticate(Customer customer) {
		//DummyDatabase data = new DummyDatabase();
	// 	System.out.println("Hello1");
		String query = "SELECT * FROM customers JOIN bankaccounts ON customers.accountId=bankaccounts.accountId WHERE custId = ? AND custPassword= ?";
		//String query1= "SELECT * FROM bankaccounts Where accountId= ?"
		
		try (Connection connection = DbUtil.getConnection()){
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, customer.getCustId());
			statement.setString(2, customer.getCustPassword());

			ResultSet result = statement.executeQuery();
		while(result.next()) {
			BankAccount localBank = new BankAccount();
			customer.setCustId(result.getLong(1));
			customer.setCustName(result.getString(2));
			customer.setCustPassword(result.getString(3));
			customer.setCustEmail(result.getString(4));
			customer.setCustAddress(result.getString(5));
			customer.setCustDob(result.getDate(6).toLocalDate());
			localBank.setAccountId(result.getInt(7));
			localBank.setAccountType(result.getString(8));
			localBank.setBalance(result.getDouble(9));
			
			customer.setCustAccount(localBank);
			
			return customer;
			
			
		}	}	catch(SQLException e) {
			e.printStackTrace();
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

		try (Connection connection = DbUtil.getConnection()){
			
			String query1 = "SELECT custPassword FROM customers WHERE custId = ?";
			PreparedStatement statement1 = connection.prepareStatement(query1);
			statement1.setLong(1, customer.getCustId());
			ResultSet result= statement1.executeQuery();
			if(oldPassword.equals(result.getString(1))) {
				
				String query = "UPDATE customers SET custPassword = ? WHERE custId= ?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, newPassword);
				statement.setLong(2, customer.getCustId());
				statement.executeQuery();
				
				return true;
			}


			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return false;
	}
	

}
