package com.yash.service;

import java.sql.SQLException;
import java.util.List;

import com.yash.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee() throws Exception;
	Employee getEmployeeById(int employeeId) throws Exception;
	String insertEmployee(Employee employee) throws ClassNotFoundException,SQLException;
	String updateEmployee(Employee employee) throws Exception;
	String deleteEmployee(Employee employee) throws Exception;
}
