package com.yash.view.employee;


import java.sql.SQLException;


import com.yash.controller.EmployeeController;

public class EmployeeUpdationView {
	
	EmployeeController employeeController;

	

	public EmployeeUpdationView() throws ClassNotFoundException, SQLException {

		employeeController=new EmployeeController();
	}
	
	

}
