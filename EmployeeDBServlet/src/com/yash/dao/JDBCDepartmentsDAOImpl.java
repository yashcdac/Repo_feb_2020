package com.yash.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.yash.entities.Departments;
import com.yash.integrate.ConnectionManager;

public class JDBCDepartmentsDAOImpl implements DepartmentsDAO {

    static Logger log = Logger.getLogger(JDBCDepartmentsDAOImpl.class.getName());
    static {
        BasicConfigurator.configure();
    }

	@Override
	public List<Departments> getAllDepartments() throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from departments");
		
		List<Departments> departmentList=new ArrayList<>();
		while(resultSet.next()) {
			Departments departments=new Departments();
			departments.setDepartmentId(resultSet.getInt("department_id"));
			departments.setDepartmentName(resultSet.getString("department_name"));
			departments.setManagerId(resultSet.getInt("manager_id"));
			departments.setLocationId(resultSet.getInt("location_id"));
			departmentList.add(departments);
		}
		ConnectionManager.closeConnection();
		log.info("Department List returned:"+departmentList);
		return departmentList;
	}

	

	@Override
	public boolean storeDeptDetails(Departments departments) {
		boolean ifDeptStored=false;
		Connection connection;
		try {
			connection = ConnectionManager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("insert into departments values(?,?,?,?)");
			statement.setInt(1,departments.getDepartmentId());
			statement.setString(2,departments.getDepartmentName());
			statement.setInt(3, departments.getManagerId());
			statement.setInt(4, departments.getLocationId());
			
			int rows=statement.executeUpdate();
			ConnectionManager.closeConnection();
			if(rows>0) {
				ifDeptStored= true;}
			return ifDeptStored;
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ifDeptStored;
		
		
		
	}



	@Override
	public boolean updateEmployee(Departments departments) throws SQLException, ClassNotFoundException {
		boolean ifdeptUpdated=false;
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update departments set department_Name=?,manager_id=?,location_id=? where department_id=?");
		statement.setString(1,departments.getDepartmentName());
		statement.setInt(2, departments.getManagerId());
		statement.setInt(3, departments.getLocationId());
		
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0) {
			ifdeptUpdated=true;}
	    return ifdeptUpdated;
	}



	@Override
	public boolean deleteDepartmentDetails(Departments departments) {
		boolean ifDeptDeleted=false;
		Connection connection;
		try {
			connection = ConnectionManager.openConnection();
			PreparedStatement statement=
					connection.prepareStatement("delete from departments where department_id=?");
			statement.setInt(1, departments.getDepartmentId());
			int rows=statement.executeUpdate();
			ConnectionManager.closeConnection();
			if(rows>0) {
				ifDeptDeleted= true;}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   return ifDeptDeleted;
	}
}
