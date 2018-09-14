package com.capgemini.bankapplication.dao.impl;

import java.util.Set;

import com.capgemini.bankapplication.dao.BankAccountDao;
import com.capgemini.bankapplication.dummydatabase.DummyDatabase;
import com.capgemini.bankapplication.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public double getBalance(long accountId) {
		
		Set<BankAccount> bankaccounts = DummyDatabase.getBankAccounts();
		for(BankAccount account1: bankaccounts) {
			if(account1.getAccountId()==accountId) {
				return account1.getBalance();
			}
		}
		return 0;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		
		Set<BankAccount> bankaccounts = DummyDatabase.getBankAccounts();
		for(BankAccount account1: bankaccounts) {
			if(account1.getAccountId()==accountId) {
				account1.setBalance(newBalance);
				
				return true;
			}
		}

		
		return false;
	}

}
