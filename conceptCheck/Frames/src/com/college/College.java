package com.college;

import java.util.List;

public class College {
	private List<Department> departments;
	private List<Student> students;
	private List<Professor> professors;
	public College(List<Department> departments, List<Student> students, List<Professor> professors) {
		super();
		this.departments = departments;
		this.students = students;
		this.professors = professors;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

}
