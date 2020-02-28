package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.yash.entities.Employee;
import com.yash.integrate.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection connection;
	private Statement statement;
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		connection=DBConnection.getConnection();
		statement=connection.createStatement();
	}
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
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
