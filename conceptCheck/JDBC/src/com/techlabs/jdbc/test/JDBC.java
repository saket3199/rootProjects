package com.techlabs.jdbc.test;
import java.sql.*;
import java.util.Scanner;

public class JDBC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Swabhav","root","admin@Sew500");
		Statement st = con.createStatement();
		String EMPID = null;
		Scanner sc = new Scanner(System.in);
		EMPID = sc.next();
		ResultSet rs = st.executeQuery("SELECT * FROM EMP WHERE EMPID ="+EMPID);
		while(rs.next()) {
		String jobs = rs.getString("EMPID");
		System.out.println(jobs);
		
		}
		System.out.println();
		String dbms = con.getCatalog();
		System.out.println("Database name: " + dbms);
		st.close();
		con.close();
		
	}

}
