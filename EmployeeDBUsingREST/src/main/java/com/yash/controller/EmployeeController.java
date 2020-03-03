package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Employee;
import com.yash.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public List<Employee> getAllEmps() {
		return employeeService.getAllEmps();
	}

	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable("id") int employeeId) {
		return employeeService.getEmpById(employeeId);
	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {

		return employeeService.updateEmployee(employee);
	}

	@PostMapping("/insertEmployee")
	public String insertEmployee(@RequestBody Employee employee) {
		System.out.println("aaaaaaaaaaaaa");
		return employeeService.insertEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {

		return employeeService.deleteEmployee(id);
	}
}
