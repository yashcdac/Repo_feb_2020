package com.yash.view.employee;

import java.sql.SQLException;

import com.yash.controller.EmployeeController;

public class AllEmployeeView {
	private EmployeeController employeeController;

	public AllEmployeeView() throws ClassNotFoundException, SQLException {
		employeeController = new EmployeeController();
	}

	public void getAllEmployeeView() throws Exception {
		employeeController.getAllEmployee().forEach(System.out::println);
	}
	
}
