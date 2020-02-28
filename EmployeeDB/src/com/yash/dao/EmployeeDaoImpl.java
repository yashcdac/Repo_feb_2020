package com.yash.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.yash.entities.Employee;
import com.yash.entities.Region;
import com.yash.integrate.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection connection;
	private Statement statement;
	private static final String ALL_EMPLOYEE = "SELECT * FROM EMPLOYEES";

	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		connection = DBConnection.getConnection();
		statement = connection.createStatement();
		
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		List<Employee> employees=new ArrayList<>();
		ResultSet rs=statement.executeQuery(ALL_EMPLOYEE);  
		while(rs.next())  
		{	  employees.add(new Employee(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"), LocalDate.parse(rs.getString("hire_date")), rs.getDouble("salary"), rs.getDouble("commission_pct"),  rs.getInt("manager_id")));
			
		}
		
		System.out.println(employees);
		return employees;
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
