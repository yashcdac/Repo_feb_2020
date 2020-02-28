package com.yash.controller;

import java.sql.SQLException;
import java.util.List;

import com.yash.entities.Employee;
import com.yash.service.EmployeeService;
import com.yash.service.EmployeeServiceImpl;

public class EmployeeController {
	
	private EmployeeService employeeService;
	public EmployeeController() throws ClassNotFoundException, SQLException {
		employeeService=new EmployeeServiceImpl();
	}
	
	/*
	 * To do by pranaw
	 * */
	public List<Employee> getAllEmployee() throws Exception {
		return employeeService.getAllEmployee();
	}

	/*
	 * To do by pranaw
	 * */
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * To do by siddhant
	 * */
	public String insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * To do by reshma
	 * */
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * To do by swati
	 * */
	public String deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
