package com.assignment.employee.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import com.assignment.employee.exception.EmployeeGenericException;
import com.assignment.employee.models.Employee;
import com.assignment.employee.models.EmployeeModel;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String DATE_FORMAT = "YYYY-MM-DD";

	private static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

	public List<EmployeeModel> getAllEmployeesByDeptNo(String deptNo) {

		String query = "SELECT * FROM EMPLOYEES E WHERE E.EMP_NO IN(SELECT DE.EMP_NO FROM DEPT_EMP DE WHERE DE.DEPT_NO=:DEPTNO)";

		
		
		List<EmployeeModel> employees = new ArrayList<>();

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("DEPTNO", deptNo);

		try {
		
		employees = jdbcTemplate.query(query, parameters, new RowMapper<EmployeeModel>() {
			@Override
			public EmployeeModel mapRow(ResultSet resultSet, int i) throws SQLException {
				return toEmployeeModel(resultSet);
			}
			
		
		});
		}
		catch (Exception e) {
			throw new EmployeeGenericException(e.getMessage());
		}
		
		return employees;

	}

	
	
	public List<Employee> getEmployeesFromHiredafterDateAndsalary(Integer vSalary, String hire_date) {

		String query = "SELECT * FROM EMPLOYEES E WHERE E.HIRE_DATE>TO_DATE(:HIREDATE,:DATEFORMATE) AND E.EMP_NO IN(SELECT S.EMP_NO FROM SALARIES S WHERE S.SALARY>= :VSALARY)";

		List<Employee> employees = new ArrayList<>();

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("VSALARY", vSalary);
		parameters.addValue("HIREDATE", hire_date);
		parameters.addValue("DATEFORMATE", DATE_FORMAT);

		try {
		
		employees = jdbcTemplate.query(query, parameters, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
				return toEmployee(resultSet);
			}
		});
		}
		catch (Exception e) {
			throw new EmployeeGenericException(e.getMessage());
		}

		return employees;

	}

	
	
	public void deleteEmployeeOnHireDate(String hireDate) {

		String sql = "DELETE FROM SALARIES WHERE EMP_NO IN(SELECT EMP_NO FROM EMPLOYEES WHERE HIRE_DATE<TO_DATE(:HIREDATE,:DATEFORMATE))";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("HIREDATE", hireDate);
		parameters.addValue("DATEFORMATE", DATE_FORMAT);
		
		try {
		int count = jdbcTemplate.update(sql, parameters);

		logger.info("Total -> {} Employee(s) have been successfully deleted from database.", count);

		}
		
		catch (Exception e) {
			throw new EmployeeGenericException(e.getMessage());
		}
	}
	
	

	private Employee toEmployee(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee();
		employee.setEmp_no(resultSet.getInt("emp_no"));
		employee.setFirst_name(resultSet.getString("first_name"));
		employee.setLast_name(resultSet.getString("last_name"));
		employee.setBirth_date(resultSet.getDate("birth_date"));
		employee.setHire_date(resultSet.getDate("hire_date"));
		employee.setGender(resultSet.getInt("gender")==0?"M":"F");
		return employee;
	}

	
	
	private EmployeeModel toEmployeeModel(ResultSet resultSet) throws SQLException {
		EmployeeModel employee = new EmployeeModel();
		employee.setEmp_no(resultSet.getInt("emp_no"));
		employee.setName(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));

		employee.setBirth_date(resultSet.getDate("birth_date"));

		return employee;
	}
}
