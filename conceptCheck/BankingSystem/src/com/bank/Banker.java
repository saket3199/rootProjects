package com.bank;

public class Banker {

	public Banker(String name, String password, double balance) {
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
//		System.out.println(name+password+balance);
	}
	public Banker() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private String name;
	private String password;
	private double balance = 0;
}
