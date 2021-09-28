package com.employee.dataAnalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DataAnalyzer {
	ArrayList<Employee> employeeList;
	PrintDetails print;

	public DataAnalyzer() throws FileNotFoundException {
		employeeList = new ArrayList<Employee>();
		String[] details;
		Scanner scanner;
		FileInputStream fis = new FileInputStream("data/output.txt");
		scanner = new Scanner(fis);
		while (scanner.hasNextLine())
		{
			details = scanner.nextLine().split(",");
			for (int i = 0; i < details.length; i++) {
				details[i] = details[i].replaceAll("[^\\w]", "");
				details[i] = details[i].replace("NULL", "0");
			}
			this.createEmployee(details);
		}
		scanner.close();
		print = new PrintDetails(employeeList);
		this.getMaximumSalaried();
		
	}

	public void createEmployee(String[] details) {
		employeeList.add(new Employee(details[1], details[2], details[4], Integer.valueOf(details[0]),
				Integer.valueOf(details[3]), Integer.valueOf(details[7]), Integer.valueOf(details[5]),
				Integer.valueOf(details[6])));
//		System.out.println(employeeList.size());
	}
	public void DepartmentCount(){
		Map<Integer, Long> employeeCountByDepartment = employeeList.stream()
		     .collect(Collectors.groupingBy(Employee::getDeptNo, 
		        TreeMap::new, Collectors.counting()));
		print.printEmployeeDepartmentCount(employeeCountByDepartment);
	}
	public void DesignationCount(){
		Map<String, Long> employeeCountByDesignation = employeeList.stream()
		     .collect(Collectors.groupingBy(Employee::getDesignation, 
		        TreeMap::new, Collectors.counting()));
		print.printEmployeeDesignationCount(employeeCountByDesignation);
	}

	public void getMaximumSalaried() {
		double max = employeeList.get(0).getSalary();
		int position = 0;
		for (int i = 1; i < employeeList.size(); i++) {
			if (employeeList.get(i).getSalary() > max) {
				max = employeeList.get(i).getSalary();
				position = i;
			}

		}
		
		print.printEmployee(position);
	}
}
