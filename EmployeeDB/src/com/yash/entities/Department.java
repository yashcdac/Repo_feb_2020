package com.yash.entities;


/*
 * 
 * Created By Pranaw
 */
public class Department {

	private int departmentId;
	private String departmentName;
	private Employee manager;
	private Location location;
	
	public Department() {
	
	}

	public Department(int departmentId, String departmentName, Employee manager, Location location) {
	
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.manager = manager;
		this.location = location;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", manager="
				+ manager + ", location=" + location + "]";
	}
	
	
}
