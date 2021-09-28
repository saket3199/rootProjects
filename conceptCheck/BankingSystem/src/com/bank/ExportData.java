package com.bank;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;

public class ExportData {
public ExportData(ResultSet rs) {
	this.writeToCSV(rs);
	
}
public void writeToCSV(ResultSet rs) {
	try (PrintWriter writer = new PrintWriter(new File("passBook.csv"))) {

	      StringBuilder sb = new StringBuilder();
	      sb.append("UserName");
	      sb.append(',');
	      sb.append("TransactionType");
	      sb.append(',');
	      sb.append("TransactionAmount");
	      sb.append(',');
	      sb.append("Date");
	      sb.append('\n');
	      
	      while (rs.next()) {
			  
			    String UserName = rs.getString("UName");
			    String transactionType = rs.getString("TransactionType");
			    double amount = rs.getDouble("TransactionAmount");
			    Date date = rs.getDate("TransactionDate");
			    sb.append(UserName);
			    sb.append(',');
			    sb.append(transactionType);
			    sb.append(',');
			    sb.append(amount);
			    sb.append(',');
			    sb.append(date.toString());
			    sb.append('\n');
			}

	      writer.write(sb.toString());

	      System.out.println("done!");

	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
}
}
