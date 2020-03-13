package com.yash.model;
public class DepartmentsModel {
	private int departmentId;
	private String departmentName;
	private int managerId;
	//private int locationId;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "DepartmentsModel [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + "]";
	}

	/*
	 * public int getLocationId() { return locationId; } public void
	 * setLocationId(int locationId) { this.locationId = locationId; }
	 */
	
	

}
