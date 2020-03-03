package com.yash.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entities.Employee;
import com.yash.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmps() {
		return employeeRepository.findAll();
	}

	public Employee getEmpById(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "updated id " + employee.getEmployeeId();
	}

	public String insertEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "inserted id " + employee.getEmployeeId();
	}

	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "deleted id " + id;
	}
}
