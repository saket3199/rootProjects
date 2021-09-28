package com.bank.subscribers;

import com.bank.publisher.Account;
import com.bank.publisher.INotifier;

public class EmailNotifier implements INotifier{

	@Override
	public void notify(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Email has been to "+account.getAccountNo()+" The latest balance is "+account.getBalance());

		
	}

}
