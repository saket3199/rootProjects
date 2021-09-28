package com.techlab.Map.test;

import java.util.HashMap;
import java.util.Map;

import com.techlab.Map.Student;

public class StudentTest {

	public static void main(String[] args) {

		Map<Student, Student> students = new HashMap<Student, Student>();
		Student s1 = new Student(1, 14, "Saket", 7.7);
		Student s2 = new Student(1, 145, "Sket", 78.7);
		Student s3 = new Student(1, 145, "Set", 77.7);
		students.put(s1, s1);
		students.put(s2, s2);
		students.put(s3, s3);
		System.out.println(students.size());

	}

	

}
