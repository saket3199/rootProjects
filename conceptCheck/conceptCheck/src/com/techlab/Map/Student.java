package com.techlab.Map;

public class Student {
	int rollNo, standard;
	String name;
	double cgpa;

	public Student(int rollNo, int standard, String name, double cgpa) {
		this.rollNo = rollNo;
		this.standard = standard;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getRollNo() {
		return rollNo;
	}

	public int getStandard() {
		return standard;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
            return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Student student = (Student) obj;
		if (student.rollNo !=(this.rollNo)  || student.standard != this.standard)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return this.rollNo;
	}
}
