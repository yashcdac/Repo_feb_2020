package com.yash.service;

import java.sql.SQLException;
import java.util.List;

import com.yash.dao.EmployeeDao;
import com.yash.dao.EmployeeDaoImpl;
import com.yash.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() throws ClassNotFoundException, SQLException {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return null;
	}

	@Override
	public String insertEmployee(Employee employee) throws SQLException,ClassNotFoundException {

		EmployeeDao dao=new EmployeeDaoImpl();
		
		return dao.insertEmployee(employee);
		
	

	}

	@Override
	public String updateEmployee(Employee employee) {
		return null;
	}

	@Override
	public String deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
