package com.college.test;

import java.util.ArrayList;

import com.college.College;
import com.college.Department;
import com.college.PrintDetails;
import com.college.Professor;
import com.college.Student;

public class CollegeTest {

	public static void main(String[] args) {

		///Professor
		ArrayList<Professor> professors = new ArrayList<Professor>();
		professors.add(new Professor("Abc"));
		professors.add(new Professor("Def"));
		professors.add(new Professor("ghi"));
		//Student
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Pqr"));
		students.add(new Student("stu"));
		students.add(new Student("vwx"));
		//Department
		ArrayList<Department> departments = new ArrayList<Department>();
		departments.add(new Department("Jkl"));
		departments.add(new Department("Mno"));
		departments.add(new Department("xyz"));
		
		College college = new College(departments, students, professors);
		new PrintDetails(college);
	}

}
