package com.yash.entities;

public class EmpLogin {
	private String username;
	private String role;
	private String password;
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmpLogin [userName=" + username + ", role=" + role + ", password=" + password + "]";
	}
	public EmpLogin(String userName, String role, String password) {
		super();
		this.username = userName;
		this.role = role;
		this.password = password;
	}
	public EmpLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


}
