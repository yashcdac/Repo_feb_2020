package com.yash.service;
import java.sql.SQLException;
import java.util.List;
import com.yash.model.DepartmentsModel;
import com.yash.model.EmployeesModel;
public interface DepartmentsService {
	public List<DepartmentsModel> retrieveDepartments();

	public DepartmentsModel getDepartmentById(int id);

	public String registerdepartment(DepartmentsModel model) ;

	public String updateDepartment(DepartmentsModel e) throws ClassNotFoundException, SQLException;

	public String deleteDepartment(DepartmentsModel departmentsModel) throws ClassNotFoundException, SQLException;
}
