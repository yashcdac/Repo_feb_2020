package com.yash.service;

import java.util.List;

import com.yash.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	Employee getEmployeeById(int employeeId);
	String insertEmployee(Employee employee);
	String updateEmployee(Employee employee);
	String deleteEmployee(Employee employee);
}
