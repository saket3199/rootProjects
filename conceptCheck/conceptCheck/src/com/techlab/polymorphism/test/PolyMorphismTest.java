package com.techlab.polymorphism.test;

import java.io.IOException;

import com.techlab.polymorphism.Accountant;
import com.techlab.polymorphism.Developer;
import com.techlab.polymorphism.Employee;
import com.techlab.polymorphism.ExportData;
import com.techlab.polymorphism.Manager;

public class PolyMorphismTest {

	public static void main(String[] args) throws IOException {

		Developer developer = new Developer("apple", 8000);
//		System.out.println("id = " + (developer.getId()) + " name = " + developer.getName() + " Salary = " + developer.getSalary() + " Bonus = "
//				+ developer.getBonus());
		printInfo(developer);
		

		Accountant accountant = new Accountant("apple", 5000);
//		System.out.println("id = " + (accountant.getId()) + " name = " + accountant.getName() + " Salary = " + accountant.getSalary() + " Bonus = "
//				+ accountant.getPerks());
		printInfo(accountant);

		Manager manager = new Manager("apple", 4000);
		printInfo(manager);
		new ExportData(manager);
	}

	public static void printInfo(Employee empl) {
		System.out.println("id = " + (empl.getId()) + " name = " + empl.getName() + " Salary = " + empl.getSalary()
				+ " Annual CTC = " + empl.getAnnualCTC() + " Department = " + empl.getClass().getSimpleName());
		if (empl.getClass() == Manager.class) {
			System.out.println(((Manager) empl).getHra());

		}
	}
}
