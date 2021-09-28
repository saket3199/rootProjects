package com.bank;

public class Register{
	
	private String userName;
	private String userPass;
	private String retypePass;
	private double balance;
	private DataProcessor database;
	
	public Register(String userName, String userPass, String retypePass, double balance) throws Exception {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.retypePass = retypePass;
		this.balance = balance;
		database = new DataProcessor();
		database.registerUser(userName, userPass, balance);
		new Banker(userName, userPass, balance);
	}


	public String getUserName() {
		return userName;
	}


	public String getUserPass() {
		return userPass;
	}


	public String getRetypePass() {
		return retypePass;
	}


	public double getBalance() {
		return balance;
	}
}