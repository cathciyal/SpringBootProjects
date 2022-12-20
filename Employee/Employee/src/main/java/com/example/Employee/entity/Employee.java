package com.example.Employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name="employee",
schema="employemanagement"
		)
public class Employee {
 
	 @Id
	 @GeneratedValue(
			  
			  strategy = GenerationType.SEQUENCE,
				 generator = "employee_generator"
			  )
	@SequenceGenerator(
				name="employee_generator",
				sequenceName = "employee_generator_name"
				)
	 private int employeeId;
	 private String employeeName;
	 private String employeeEmail;
	 private String dept;
	 
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	 
	 
}
