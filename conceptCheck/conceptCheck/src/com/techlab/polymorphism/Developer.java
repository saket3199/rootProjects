package com.techlab.polymorphism;

public class Developer extends Employee{

	double bonus;
	public Developer(String name, double salary) {
		super(name, salary);
		this.bonus=(40*salary)/100;
	}
	public double getBonus() {
		return bonus;
	}

}
