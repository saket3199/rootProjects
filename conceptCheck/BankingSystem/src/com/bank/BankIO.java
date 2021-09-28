package com.bank;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankIO {
	private Banking banking;
	public BankIO(){
		
	}
	public void getUserDeposit() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the amount to be deposited: ");
		int amt = input.nextInt();
		banking = new Banking(Login.getBanker());
		banking.deposit(amt);
		input.close();

	}

	public void getUserWithDrawal() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the amount to withdraw:");
		int withdrawAmt = input.nextInt();
//		banking = new Banking();
		banking = new Banking(Login.getBanker());
		try {
			banking.withdraw(withdrawAmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		input.close();
	}
	
	public void showAccountBalance(double amount) {
		System.out.println("Your Account Balance is "+amount+" Rupees");
        System.out.println(" ");
	}
	
	public void getUserCreditienals() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your Login Creditienals\n");
		System.out.println("Enter the UserName:");
		String user = input.next();
		System.out.println("Enter the Password:");
		String pass = input.next();
		new Login(user, pass);
//		input.close();
	}
	
	public void registerUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to XYZ Bank..");
		System.out.println("Enter your desired UserName:");
		String user = input.next();
		System.out.println("Enter your desired Password:");
		String pass = input.next();
		System.out.println("Please re-enter your Password");
		String retypePass = input.next();
		if(pass.equals(retypePass)) {
			System.out.println("Enter your Deposit Amount");
			double amount = input.nextDouble();
			try {
				new Register(user, pass, pass, amount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Pass and Re-Type Passwords Dosent Match");
		}
		input.close();
	}

	public void showUserDeposit(double amount) {
		System.out.println("Amount deposited Successfully");
        System.out.println(" ");
        System.out.println("Total Balance: " +amount);
        System.out.println(" ");
		
	}

	public void showUserWithDrawal(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Please Collect your " + amount +" Rupees");
        System.out.println(" ");
        System.out.println("Total Balance: " +amount);
        System.out.println(" ");
		
	}
	public void printPassBook() {
		// TODO Auto-generated method stub
		System.out.println("Please wait priniting your passbook");
//		banking = new Banking();
		banking = new Banking(Login.getBanker());
		ResultSet rs = banking.printPassBook();
		try {
			while (rs.next()) {
				  
			    String UserName = rs.getString("UName");
			    String transactionType = rs.getString("TransactionType");
			    double amount = rs.getDouble("TransactionAmount");
			    Date date = rs.getDate("TransactionDate");
			    System.out.println(UserName + "\t\t" + transactionType+ "\t\t" + amount +"\t\t" + date);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	public void exportPassBook() {
		// TODO Auto-generated method stub
		System.out.println("Please wait exporting your passbook");
//		banking = new Banking();
		banking = new Banking(Login.getBanker());
		ResultSet rs = banking.printPassBook();
		new ExportData(rs);
		
		
	}

}
