package com.assignment.employee;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	
	@Autowired
	private DataSource dataSource;

	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate() {
		/*
		 * JdbcTemplate jdbcTemplate= new JdbcTemplate();
		 * jdbcTemplate.setDataSource(dataSource);
		 */
		return new NamedParameterJdbcTemplate(dataSource);
		
	}
}
