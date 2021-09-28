package com.techlab.polymorphism;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportData {
	public String template = "<table border=\"1\">"
			+ "    <td>ID</td>"
			+ "    <td>$id</td>"
			+ "    <tr>"
			+ "    <td>Name</td>"
			+ "    <td>$name</td>"
			+ "    <tr>"
			+ "    <td>Deapartment</td>"
			+ "    <td>$department</td>"
			+ "    </tr>"
			+ "    <tr>"
			+ "    <td>Salary</td>"
			+ "    <td>$salary</td>"
			+ "    </tr>"
			+ "    <tr>"
			+ "    <td>Bonus</td>"
			+ "    <td>$bonus</td>"
			+ "    </tr>"
			+ "    <tr>"
			+ "    <td>Total Salary</td>"
			+ "    <td>$annualCTC</td>"
			+ "    </tr>"
			+ "    <tr>"
			+ "    <td>HRA Allowance</td>"
			+ "    <td>$HRA</td>"
			+ "    </tr>"
			+ "    <tr>"
			+ "    <td>TA</td>"
			+ "    <td>$TA</td>"
			+ "    </tr>"
			+ "    </table>";
	
	public ExportData(Employee emp) throws IOException {
		String name="",department="";
		int id;
		double salary=0,bonus=0,annualCTC=0,HRA=0,TA=0;
		id = emp.getId();
		name=emp.getName();
		department = emp.getClass().getSimpleName();
		salary = emp.getSalary();
		annualCTC = emp.getAnnualCTC();
		if(emp.getClass()==Manager.class) {
			HRA = ((Manager) emp).getHra();
			TA = ((Manager) emp).getTa();
			bonus = HRA+TA;
		}
		if(emp.getClass()==Developer.class) {
			bonus = ((Developer) emp).getBonus();
		}
		if(emp.getClass()==Accountant.class) {
			bonus= ((Accountant) emp).getPerks();
		}
		template =template.replace("$id", String.valueOf(id));
		template =template.replace("$name", name);
		template =template.replace("$department", department);
		template =template.replace("$salary", String.valueOf(salary));
		template =template.replace("$bonus", String.valueOf(bonus));
		template =template.replace("$annualCTC", String.valueOf(annualCTC));
		template =template.replace("$HRA", String.valueOf(HRA));
		template =template.replace("$TA", String.valueOf(TA));
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(name+id+department+".html"));
	    writer.write(template);
	    writer.close();
	}


}
