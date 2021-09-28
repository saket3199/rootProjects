package com.bank.subscribers;

import com.bank.publisher.Account;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc1  = new Account(101,"Saket",5000);
		acc1.addNotifier(new SmsNotifier());
		acc1.addNotifier(new EmailNotifier());
		acc1.deposit(1000);

	}

}
