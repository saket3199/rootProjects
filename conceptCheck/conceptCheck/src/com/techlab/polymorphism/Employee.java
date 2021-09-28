package com.techlab.polymorphism;

public class Employee {
	private static int id = 1001;
	private String name;
	private double salary;
	private double annualCTC;


	public Employee(String name, double salary) {
		
		this.name = name;
		this.salary = salary;
		this.annualCTC = 12*salary;
	}

	public int getId() {
		return id++;
	}

	public String getName() {
		return name;

	}

	public double getSalary() {
		return salary;
	}
	public double getAnnualCTC() {
		return annualCTC;
	}

}
