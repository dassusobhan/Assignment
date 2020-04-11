1)get all employees empno,name(firstName+lastName),birthdate by a given deptno

  URI-> /employees/dept/{dept_no} 

  EXAMPLE-> http://localhost:8081/employees/dept/d007


2)get employees list who are hired after a given date and a given min salary 
  
  URI-> /employees/hiredate/{somedate}/salary/{salary}
  
  EXAMPLE-> http://localhost:8081/employees/hiredate/1986-12-01/salary/66074
  

3)delete employee record(s) from salaries table whose hiredates are before a given_date 

  URI-> /employees/salaries/employee/hiredate/{somedate}

  EXAMPLE->http://localhost:8081/employees/salaries/employee/hiredate/1986-12-01
