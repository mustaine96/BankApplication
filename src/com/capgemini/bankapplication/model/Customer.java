package com.capgemini.bankapplication.model;

import java.time.LocalDate;

public class Customer {

	private long custId;
	private String custName;
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPassword=" + custPassword
				+ ", custEmail=" + custEmail + ", custAddress=" + custAddress + ", custDob=" + custDob
				+ ", custAccount=" + custAccount + "]";
	}
	private String custPassword;
	private String custEmail;
	private String custAddress;
	private LocalDate custDob;
	private BankAccount custAccount;
	public Customer(long custId, String custName, String custPassword, String custEmail, String custAddress,
			LocalDate custDob, BankAccount custAccount) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custPassword = custPassword;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.custDob = custDob;
		this.custAccount = custAccount;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public LocalDate getCustDob() {
		return custDob;
	}
	public void setCustDob(LocalDate custDob) {
		this.custDob = custDob;
	}
	public BankAccount getCustAccount() {
		return custAccount;
	}
	public void setCustAccount(BankAccount custAccount) {
		this.custAccount = custAccount;
	}
}
