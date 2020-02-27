package com.yash.entities;

import java.time.LocalDate;
import java.util.Date;
/*
 * 
 * Created By Pranaw
 */
public class JobHistory {

	private int employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
	private Job job;
	private Department department;
	public JobHistory() {
		
	}
	
	public JobHistory(int employeeId, LocalDate startDate, LocalDate endDate, Job job, Department department) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "JobHistory [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate + ", job="
				+ job + ", department=" + department + "]";
	}
	

	
	
	
}
