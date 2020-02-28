package com.yash.entities;

import java.time.LocalDate;

/*
 * 
 * Created By Pranaw
 */
public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private double salary;
	private double commissionPct;
	private Job job;
	private int managerId;
	private Department department;

	private Employee(Employee.EmployeeBulider builder) {
		this.email=builder.email;
		this.phoneNumber=builder.phoneNumber;
		this.salary=builder.salary;
		this.commissionPct=builder.commissionPct;
		//this.job=builder.job;
		this.managerId=builder.managerId;
		//this.department=builder.department;
	}
	private static class EmployeeBulider{
		private String email;
		private String phoneNumber;
		private double salary;
		private double commissionPct;
		//private Job job;
		private int managerId;
		//private Department department;
		
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public void setCommissionPct(double commissionPct) {
			this.commissionPct = commissionPct;
		}
		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}
		public Employee build(){
			return new Employee(this);
		}
		
	}
	
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate hireDate, double salary, double commissionPct, Job job, int managerId, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.job = job;
		this.managerId = managerId;
		this.department = department;
	}
	
	

	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate hireDate, double salary, double commissionPct, int managerId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", job=" + job + ", managerId=" + managerId + ", department="
				+ department + "]";
	}

}
