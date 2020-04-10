package com.assignment.employee.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EmployeeResponseEntityExcetionHandler extends ResponseEntityExceptionHandler {

	
	/*
	 * @ExceptionHandler(Exception.class ) protected
	 * ResponseEntity<EmployeeExceptionResponse> handleAll(Exception ex, WebRequest
	 * request) { EmployeeExceptionResponse employeeExceptionResponse=new
	 * EmployeeExceptionResponse(new Date(), ex.getMessage(),
	 * request.getDescription(true)); return new
	 * ResponseEntity<EmployeeExceptionResponse>(employeeExceptionResponse,
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	@ExceptionHandler(EmployeeGenericException.class )
	protected ResponseEntity<EmployeeExceptionResponse> handleEmployeeGenericException(EmployeeGenericException ex, WebRequest request) {
		EmployeeExceptionResponse employeeExceptionResponse=new EmployeeExceptionResponse(new Date(),
				ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<EmployeeExceptionResponse>(employeeExceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
