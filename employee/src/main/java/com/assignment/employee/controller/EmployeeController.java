package com.assignment.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.models.Employee;
import com.assignment.employee.models.EmployeeModel;
import com.assignment.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	
	@GetMapping(value="/employees/dept/{deptNo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeModel>> getAllEmployeesByDeptNo(@PathVariable("deptNo") String deptNo){
		List<EmployeeModel> employees= service.getAllEmployeesByDeptNo(deptNo);
		return ResponseEntity.ok(employees);
		
	}
	
	
	
	@GetMapping(value="/employees/hiredate/{somedate}/salary/{salary}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeesFromHiredafterDateAndsalary(@PathVariable("salary") Integer vSalary,@PathVariable("somedate") String date) {
		List<Employee> employees=service.getEmployeesFromHiredafterDateAndsalary(vSalary, date);
		return ResponseEntity.ok(employees);
	}

        @DeleteMapping(value="employees/salaries/employee/hiredate/{somedate}")
	public ResponseEntity<?> deleteEmployeeOnHireDate(@PathVariable("somedate") String date) {
		service.deleteEmployeeOnHireDate(date);
		
		return ResponseEntity.noContent().build();
	}
	
}
