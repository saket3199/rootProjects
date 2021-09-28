package com.bank;

import java.sql.ResultSet;

public class Banking {
	private Banker banker;
	private double amount;
	private BankIO instructions;
	private DataProcessor database;

	public Banking(Banker banker) {
		instructions = new BankIO();
		this.banker= banker;
		amount = banker.getBalance();
		try {
			database = new DataProcessor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getBalance() {
		return amount;
	}

	public void deposit(int amt) {
		try {
			amount = amount + amt;
			instructions.showUserDeposit(amount);
			database.updateBalance(banker.getName(), Transaction.Deposit, amt, amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void withdraw(int amt) throws Exception {
		if (amount < amt) {
			InvalidBankTransaction invalidWithDraw = new InvalidBankTransaction("InValid Withdrawal Amount");
			throw invalidWithDraw;
		} else {
			try {
				amount = (amount - amt);
				instructions.showUserWithDrawal(amt);
				database.updateBalance(banker.getName(), Transaction.WithDraw, amt, amount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public ResultSet printPassBook() {
		try {
			return database.getAllTransactions(banker.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println(e);
		return null;
		}
	}
	public ResultSet exportPassBook() {
		try {
			return database.getAllTransactions(banker.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		return null;
		}
	}
}
