package com.employee.dataAnalyzer;

public class Employee {
	String name,designation,date;
	int empID,mngrID,deptNo;
	double salary,commission;
//	Employee name, Employee designation, Manager id, 
//	Date of joining, Salary, Commission and Department number.
	public Employee(String name, String designation, String date, int empID, int mngrID, int deptNo, double salary,
			double commission) {
		super();
		this.name = name;
		this.designation = designation;
		this.date = date;
		this.empID = empID;
		this.mngrID = mngrID;
		this.deptNo = deptNo;
		this.salary = salary;
		this.commission = commission;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public String getDate() {
		return date;
	}
	public int getEmpID() {
		return empID;
	}
	public int getMngrID() {
		return mngrID;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public double getSalary() {
		return salary;
	}
	public double getCommission() {
		return commission;
	}
	

}
