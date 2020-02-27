package com.yash.tester;

import java.sql.SQLException;

import com.yash.dao.RegionDaoImpl;

public class EmployeeTest {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, Exception {
		
		System.out.println(new RegionDaoImpl().getAllRegions());
	}

}
