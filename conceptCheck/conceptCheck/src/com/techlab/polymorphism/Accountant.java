package com.techlab.polymorphism;

public class Accountant extends Employee{
	double perks;

	public Accountant(String name, double salary) {
		super(name, salary);
		this.perks=(30*salary)/100;
	}
	public double getPerks() {
		return perks;
	}
	


}
