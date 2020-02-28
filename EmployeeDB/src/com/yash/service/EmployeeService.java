package com.yash.service;

import java.util.List;

import com.yash.entities.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee() throws Exception;
	Employee getEmployeeById(int employeeId) throws Exception;
	String insertEmployee(Employee employee) throws Exception;
	String updateEmployee(Employee employee) throws Exception;
	String deleteEmployee(Employee employee) throws Exception;
}
