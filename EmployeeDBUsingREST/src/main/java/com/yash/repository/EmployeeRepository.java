package com.yash.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
