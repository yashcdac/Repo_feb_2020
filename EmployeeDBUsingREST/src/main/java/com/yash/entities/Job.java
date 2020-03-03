package com.yash.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * 
 * Created By Pranaw
 */
@Table(name = "jobs")
@Entity(name = "jobs")
public class Job {

	@Id
	private String jobId;
	private String jobTitle;
	private double minSalary;
	private double maxSalary;

	@JsonManagedReference
	@OneToMany(mappedBy = "job")
	private List<Employee> employees;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String jobId, String jobTitle, double minSalary, double maxSalary, List<Employee> employees) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}

}
