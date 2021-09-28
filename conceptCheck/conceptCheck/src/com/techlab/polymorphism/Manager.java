package com.techlab.polymorphism;

public class Manager extends Employee{
	double hra,ta;

	public Manager(String name, double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	this.hra=(50*salary)/100;
	this.ta=(40*salary)/100;
	}
	public double getHra() {
		return hra;
	}
	public double getTa() {
		return ta;
	}
}
