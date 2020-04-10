package com.assignment.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeGenericException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266869845154210065L;

	public EmployeeGenericException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeGenericException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public EmployeeGenericException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public EmployeeGenericException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EmployeeGenericException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	

}
