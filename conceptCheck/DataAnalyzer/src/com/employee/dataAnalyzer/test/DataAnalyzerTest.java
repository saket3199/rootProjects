package com.employee.dataAnalyzer.test;

import java.io.IOException;

import com.employee.dataAnalyzer.DataLoader;
import com.employee.dataAnalyzer.DataAnalyzer;

public class DataAnalyzerTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Design a business model for employee data analyzer application ,
//		where the data will initially loaded from a disk(file attahced) , 
//		it could also have feature to load from web
//		url is  https://swabhav-tech.firebaseapp.com/emp.txt 
		          
//		The csv file consists of employee details i.e Employee id, 
//			Employee name, Employee designation, Manager id, 
//			Date of joining, Salary, Commission and Department number.
//			The file also consists of duplicated data. 
//			Load and parse file to find the maximum salaried employee, 
//			find the total number of employees based on their designation and department no.
		new DataLoader();
	}

}
