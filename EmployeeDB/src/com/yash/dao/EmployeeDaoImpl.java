package com.yash.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.yash.entities.Department;
import com.yash.entities.Employee;
import com.yash.entities.Job;
import com.yash.integrate.DBConnection;

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
	public List<Employee> getAllEmployee()throws ClassNotFoundException,SQLException {
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
		try {
			System.out.println(employee);
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into employees(employee_id,first_name,last_name,email,phone_number,hire_date,salary,job_id) values(?,?,?,?,?,?,?,?)");
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getPhoneNumber());
			statement.setString(6, employee.getHireDate().toString());
			statement.setDouble(7, employee.getSalary());
			statement.setString(8,"AC_MGR");
			int n=statement.executeUpdate();

			if(n>0) {
				return "successfully inserted "+n+" records";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "successfully not inserted";
	}

	@Override
	public String updateEmployee(Employee employee) {
		String sql = "UPDATE Employee SET email=?,phoneNumber=?,salary=?,commissionPct=?,managerId=?"
				+ "WHERE employeeId=?";
		 
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, "BillGates@gmail.com");
			statement.setString(2, "9867543425");
			statement.setDouble(3, 45000.0);
			statement.setDouble(4, 20.0);
			statement.setInt(5, 10);
			
			int rowsUpdated = statement.executeUpdate();
			
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			    String msg="An existing user was updated successfully!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		
		return "An existing user was updated successfully!";
	}

	@Override
	public String deleteEmployee(Employee employee) {
		return null;

	}

}
