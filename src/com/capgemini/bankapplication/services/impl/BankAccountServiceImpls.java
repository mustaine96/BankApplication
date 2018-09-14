package com.capgemini.bankapplication.services.impl;


import java.util.Set;

import com.capgemini.bankapplication.dao.BankAccountDao;
import com.capgemini.bankapplication.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankapplication.dummydatabase.DummyDatabase;
import com.capgemini.bankapplication.model.BankAccount;
import com.capgemini.bankapplication.services.BankAccountService;

public class BankAccountServiceImpls implements BankAccountService {
	
	private BankAccountDao bankAccountDao;
	
	

	public BankAccountServiceImpls() {
		super();
		bankAccountDao = new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) {
		
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) {
		
		if (bankAccountDao.getBalance(accountId) >= amount) {
		 bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId) - amount);
		 return (bankAccountDao.getBalance(accountId) - amount);
		 
		}
		return -1;
		
	}

	@Override
	public double deposit(long accountId, double amount) {
		
		bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId) + amount);
		return bankAccountDao.getBalance(accountId);
		
		
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) {
		
		if(withdraw(fromAcc, amount)!= -1) {
			deposit(toAcc,amount);
			return true;
		}
		else
			return false;
		
	}

}
