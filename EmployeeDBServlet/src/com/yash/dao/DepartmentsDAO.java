package com.yash.dao;
import java.sql.SQLException;
import java.util.List;
import com.yash.entities.Departments;
public interface DepartmentsDAO {
	public List<Departments> getAllDepartments() throws ClassNotFoundException, SQLException;

	public boolean storeDeptDetails(Departments departments) ;

	public boolean updateEmployee(Departments departments) throws SQLException, ClassNotFoundException;

	public boolean deleteDepartmentDetails(Departments departments);
}
