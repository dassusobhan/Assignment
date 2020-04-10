package com.assignment.employee.models;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class EmployeeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7337786246939689218L;

	@NotNull(message = "Employee No should not be null") 
	private Integer emp_no;

	@NotNull(message = "Employee No should not be null") 
	@Past(message = "Birth Date should be of past date") 
	private Date birth_date;

	@NotNull(message = "Name should not be null")
	private String name;
	

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeModel(Integer emp_no, Date birth_date, String name) {
		super();
		this.emp_no = emp_no;
		this.birth_date = birth_date;
		this.name = name;
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
