package com.yash.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.entities.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int employeeId);
	String insertEmployee(Employee employee);
	String updateEmployee(Employee employee) throws SQLException;
	String deleteEmployee(Employee employee);
	

	 
}
