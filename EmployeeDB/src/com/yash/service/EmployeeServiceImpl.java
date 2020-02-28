package com.yash.service;

import java.util.List;

import com.yash.dao.EmployeeDao;
import com.yash.dao.EmployeeDaoImpl;
import com.yash.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {

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
		EmployeeDao dao=new EmployeeDaoImpl();
		
		return dao.insertEmployee(employee);
		
		
		
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
