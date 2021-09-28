package com.bank.publisher;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNo;
	private String name;
	private static double balance =0;
	private List<INotifier> notifiers = new ArrayList<INotifier>();

	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public Account(int accountNo, String name, double balance) {
		super();
//		notifiers = ;
		this.accountNo = accountNo;
		this.name = name;
		Account.balance = balance;
	}

	public List<INotifier> getNotifiers() {
		return notifiers;
	}

	public void setNotifiers(List<INotifier> notifiers) {
		this.notifiers = notifiers;
	}

	public void addNotifier(INotifier notifier) {
		notifiers.add(notifier);
	}
	
	public void deposit(double amount) {
		balance+=amount;
		this.notifyUsers();
	}
	public void withdraw(double amount) {
		balance-=amount;
		this.notifyUsers();
	}
	
	public void notifyUsers(){
		for(INotifier notifier: this.notifiers) {
			notifier.notify(this);
		}
	}
}
