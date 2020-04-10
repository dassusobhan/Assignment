package com.assignment.employee.exception;

import java.util.Date;

public class EmployeeExceptionResponse {
	 
	 private Date time;
	 
	 private String message;
	 
	 private String description;

	public EmployeeExceptionResponse() {
		
	}

	public EmployeeExceptionResponse(Date time, String message, String description) {
		super();
		this.time = time;
		this.message = message;
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	 
	 
}
