package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.yash.entities.Department;
import com.yash.entities.Employee;
import com.yash.entities.Job;
import com.yash.integrate.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {


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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
