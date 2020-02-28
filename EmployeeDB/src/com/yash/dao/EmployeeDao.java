package com.yash.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.entities.Employee;

public interface EmployeeDao {

<<<<<<< HEAD
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int employeeId);
	String insertEmployee(Employee employee);
	String updateEmployee(Employee employee) throws SQLException;
	String deleteEmployee(Employee employee);
	
=======
	List<Employee> getAllEmployee() throws Exception;
	Employee getEmployeeById(int employeeId) throws Exception;
	String insertEmployee(Employee employee) throws Exception;
	String updateEmployee(Employee employee) throws Exception;
	String deleteEmployee(Employee employee) throws Exception;
	 
>>>>>>> branch 'master' of https://github.com/yashcdac/Repo_feb_2020.git
}
