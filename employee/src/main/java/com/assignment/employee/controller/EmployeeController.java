package com.assignment.employee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
	@GetMapping("/employees/dept/{deptNo}")
	public ResponseEntity<List<EmployeeModel>> getAllEmployeesByDeptNo(@PathVariable("deptNo") String deptNo){
		List<EmployeeModel> employees= service.getAllEmployeesByDeptNo(deptNo);
		return ResponseEntity.ok(employees);
		
	}
	
	
	
	@GetMapping("/employees/hiredate/{hiredate}/salary/{salary}")
	public ResponseEntity<List<Employee>> getEmployeesFromHiredafterDateAndsalary(@PathVariable("salary") Integer vSalary,@PathVariable("hiredate") String hire_date) {
		List<Employee> employees=service.getEmployeesFromHiredafterDateAndsalary(vSalary, hire_date);
		return ResponseEntity.ok(employees);
	}

    @DeleteMapping("employees/salaries/employee/hiredate/{hiredate}")
	public ResponseEntity<?> deleteEmployeeOnHireDate(@PathVariable("hiredate") String hireDate) {
		service.deleteEmployeeOnHireDate(hireDate);
		
		return ResponseEntity.noContent().build();
	}
	
}
