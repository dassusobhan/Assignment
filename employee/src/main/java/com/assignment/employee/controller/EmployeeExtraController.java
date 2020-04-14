package com.assignment.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.ExtraProperty;
import com.assignment.employee.models.Employee;
import com.assignment.employee.models.EmployeeModel;
import com.assignment.employee.service.EmployeeService;

@RestController
public class EmployeeExtraController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	ExtraProperty prorerty;
	
	
	@GetMapping(value="/employees/limits",produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer getLimits(){
		
		Integer max=prorerty.getMax();
		
		return max;
		
	}
	
	
	
	
}
