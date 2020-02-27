package com.yash.entities;

import java.util.Date;
/*
 * 
 * Created By Pranaw
 */
public class JobHistory {

	private int employeeId;
	private Date startDate;
	private Date endDate;
	private String jobId;
	private int departmentId;
	public JobHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobHistory(int employeeId, Date startDate, Date endDate, String jobId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "JobHistory [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate + ", jobId="
				+ jobId + ", departmentId=" + departmentId + "]";
	}
	
	
}
