package com.assignment.employee.models;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337786246939689218L;

	@NotNull(message = "Employee No should not be null") 
	private Integer emp_no;

	@NotNull(message = "Employee No should not be null") 
	@Past(message = "Birth Date should be of past date") 
	private Date birth_date;

	@NotNull(message = "FirstName should not be null")
	private String first_name;
	
	@NotNull(message = "LastName should not be null")
	private String last_name;

	/* private String gender; ENUM ('M','F'); */
	@NotNull(message = "Employee Hire date should not be null") 
	private Date hire_date;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer emp_no, Date birth_date, String first_name, String last_name,
			Date hire_date) {
		super();
		this.emp_no = emp_no;
		this.birth_date = birth_date;
		this.first_name = first_name;
		this.last_name = last_name;
		/* this.gender = gender; */
		this.hire_date = hire_date;
	}

	public Integer getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/*
	 * public String getGender() { return gender; }
	 * 
	 * public void setGender(String gender) { this.gender = gender; }
	 */
	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

}
