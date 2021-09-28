package com.employee.dataAnalyzer;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class PrintDetails {
	ArrayList<Employee> employeeList;
	public PrintDetails(ArrayList<Employee> employeeList) {
		this.employeeList=employeeList;
		this.printAllEmployees();
	}
	public void printAllEmployees() {
		System.out.println("All the Employees in the organisation are  :\n");
		for(Employee e: employeeList) {
			System.out.println("Name : "+e.getName());
			System.out.println("EmpId : "+e.getEmpID());
			System.out.println("DOJ : "+e.getDate());
			System.out.println("Designation : "+e.getDesignation());
			System.out.println("ManagerId : "+e.getMngrID());
			System.out.println("Salary : "+e.getSalary());
			System.out.println("Commission : "+e.getCommission());
			System.out.println("DepartmentNo : "+e.getDeptNo());
			System.out.println("\n");
		}
	}
	public void printEmployee(int i) {
		System.out.printf("%nDetails of Maximum Salaried Employee:%n"); 
		ArrayList<Employee> e = employeeList;
		System.out.println("Name : "+e.get(i).getName());
		System.out.println("EmpId : "+e.get(i).getEmpID());
		System.out.println("DOJ : "+e.get(i).getDate());
		System.out.println("Designation : "+e.get(i).getDesignation());
		System.out.println("ManagerId : "+e.get(i).getMngrID());
		System.out.println("Salary : "+e.get(i).getSalary());
		System.out.println("Commission : "+e.get(i).getCommission());
		System.out.println("DepartmentNo : "+e.get(i).getDeptNo());
		System.out.println("\n");
	}
	
	public void printEmployeeDepartmentCount(Map<Integer, Long> employeeCountByDepartment) {
		System.out.printf("%nCount of Employees by department:%n"); 
			      employeeCountByDepartment.forEach(
			         (department, count) -> System.out.printf(
			            "%s has %d employee(s)%n", department, count));
			      System.out.println("\n");
			      
	}
	public void printEmployeeDesignationCount(Map<String, Long> employeeCountByDesignation) {
		  System.out.printf("%nCount of Employees by Designation:%n");
		      employeeCountByDesignation.forEach(
		         (designation, count) -> System.out.printf(
		            "%s has %d employee(s)%n", designation, count));
		      System.out.println("\n");
	}

}
