package com.college;

public class PrintDetails {
	public PrintDetails(College college) {
		super();
		this.college = college;
		this.printDetails(college);
	}

	private College college;

	public College getCollege() {
		return college;
	}

	public void printDetails(College college) {
		System.out.println("Total no of Students are "+ college.getStudents().size());
		System.out.println("Total no of Professors are "+ college.getProfessors().size());
		System.out.println("Total no of Departments are "+ college.getDepartments().size());

	}

}
