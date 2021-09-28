package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataProcessor {
	private Connection con;

	public DataProcessor() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin@Sew500");
	}

	public void registerUser(String userName, String pass, double amount) throws Exception {
		String insertQuery = "INSERT INTO Bank_Master VALUES ('" + userName + "','" + pass + "'," + amount + ")";
		String updateQuery = "INSERT INTO bank_transaction VALUES ('" + userName + "','Deposit'," + amount + "," + "'"
				+ java.time.LocalDate.now() + "')";

		try {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertQuery);
			stmt.executeUpdate(updateQuery);
			// If there is no error.
			con.commit();
		} catch (Exception se) {
			// If there is any error.
			con.rollback();
		}
	}

	public void updateBalance(String userName, Transaction transaction, double amount, double balance)
			throws Exception {
		String insertQuery = "INSERT INTO bank_transaction VALUES ('" + userName + "','" + transaction + "'," + amount
				+ "," + "'" + java.time.LocalDate.now() + "')";
		String updateQuery = "UPDATE bank_master SET UBalance = " + balance + " WHERE Uname = '" + userName + "'";
		try {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertQuery);
			stmt.executeUpdate(updateQuery);
			// If there is no error.
			con.commit();
		} catch (Exception se) {
			// If there is any error.
			con.rollback();
		}

	}

	public ResultSet getAllTransactions(String name) {
		// TODO Auto-generated method stub
		String query = "Select * from bank_transaction where Uname ='"+name+"'";
		Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
		
		
		return rs;
		
		
	}

}
