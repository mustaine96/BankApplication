package com.capgemini.bankapplication.dummydatabase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.bankapplication.model.BankAccount;
import com.capgemini.bankapplication.model.Customer;

public class DummyDatabase {

	
	//DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	//Date date = new Date(14, 9, 2018);

	private static Set<Customer> customers =new HashSet<Customer>();
	private static Set<BankAccount> bankAccounts= new HashSet<>();
	
	
	BankAccount account1 = new BankAccount(1,"SavingsAccount", 25000);
	BankAccount account2= new BankAccount(2,"SalaryAccount", 12000);
	BankAccount account3= new BankAccount(3, "Disabled", 0);
	
	Customer customer1= new Customer(01, "Jimmi", "asdfg", "jimmi@gmail.com", "f4567 asdress street",LocalDate.now(), account1);
	Customer customer2=new Customer(2, "gates", "asdf", "gates@gmail.com", "123 some street", LocalDate.now(), account2);
	Customer customer3=new Customer(3, "no", "asd", "no@no.no", "no no noooo", LocalDate.now(), account3);
	public DummyDatabase() {
		super();
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
		bankAccounts.add(account1);
		bankAccounts.add(account2);
		bankAccounts.add(account3);
		
		//this.df = df;
		//this.date = date;
		
	}
	public static Set<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}
	
	public static Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public static void setBankAccounts(Set<BankAccount> bankAccounts) {
		DummyDatabase.bankAccounts = bankAccounts;
	}
	
	public static void setCustomers(Set<Customer> customers) {
		DummyDatabase.customers = customers;
	}
	
	
	
	
}
