package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
	private String userName;
	private String password;
	private static boolean isLoggedIn = false;
	private BankIO input;
	static Banker banker;

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
//		input = new BankIO();
//		input.getUserCreditienals();
		try {
			Login.checkLogin(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public static boolean isLoggedIn() {
		return isLoggedIn;
	}

	public static void setLoggedIn(boolean isLoggedIn) {
		Login.isLoggedIn = isLoggedIn;
	}

//	int ac_number = 1234;
//	int ac_pass = 9999;
//	int ac;
//	int pw;

//	public void acceptInput() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the account number:");
//		ac = scanner.nextInt();
//		System.out.println("Enter the Password:");
//		pw = scanner.nextInt();
//		scanner.close();
//	}

//	public void verify() throws Exception {
//
//		if (ac == ac_number && pw == ac_pass) {
//			System.out.println("Login Successfull!");
//			Banking banking = new Banking();
//			System.out.println(" ");
//			System.out.println("Your Balance is: " + banking.getBalance() + "  Rupees");
//			System.out.println(" ");
////            Menu menu = new Menu();
////            menu.showMenu();
//		} else {
//			InvalidBankTransaction loginfailed = new InvalidBankTransaction("Incorrect login credentials");
//			System.out.println(loginfailed.getMessage());
//			throw loginfailed;
//		}
//	}

	private static boolean checkLogin(String username, String password) throws Exception {
		System.out.print("");

		PreparedStatement pt = null; // manages prepared statement

		// connect to database usernames and query database
		try {

			// establish connection to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin@Sew500");

//			 query database
			pt = con.prepareStatement("Select * from bank_master where Uname = ?");

			// process query results
			pt.setString(1, username);
			ResultSet rs = pt.executeQuery();
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("Select * from bank_master where Uname ="+username);
			String orgUname = "", orPass = "";
			while (rs.next()) {
				orgUname = rs.getString("UName");
				orPass = rs.getString("Upass");
				break;
			} // end while
//			System.out.println(orgUname+orPass);
			if (orPass.trim().equals(password.trim())) {
				// do something
				try {
					banker= new Banker(rs.getString("UName"), rs.getString("UPass"), Double.parseDouble(rs.getString("UBalance")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new Banking(banker);
//				System.out.print(rs.getString("UName")+rs.getString("UPass")+ Double.parseDouble(rs.getString("UBalance")));
				isLoggedIn = true;
//				rs.close();
				return true;
			} else {
				// do something
				isLoggedIn = false;
			
				InvalidBankTransaction loginfailed = new InvalidBankTransaction("Incorrect login credentials");
//				System.out.println(loginfailed.getMessage());
				throw loginfailed;
			}

		} // end try
		catch (Exception e) {
//			System.out.println(e);
			return false;
		} // end catch
		
		
	} // end main

	public static Banker getBanker() {
		return banker;
	}
}
