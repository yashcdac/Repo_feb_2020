package com.yash.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.yash.dao.DepartmentsDAO;
import com.yash.entities.Departments;
import com.yash.entities.Employees;
import com.yash.exception.NoEmployeeFoundException;
import com.yash.helper.FactoryEmployeeDB;
import com.yash.model.DepartmentsModel;
import com.yash.model.EmployeesModel;
public class DepartmentsServiceImpl implements DepartmentsService {
	
	private static final String RESULTFORSUCCESS="success";
	private static final String RESULTFORFAILURE="fail";
    static Logger log = Logger.getLogger(DepartmentsServiceImpl.class.getName());
	 private DepartmentsDAO departmentsDAO;
		public DepartmentsServiceImpl() {
			this.departmentsDAO=FactoryEmployeeDB.createDepartmentsDAO();
	        //BasicConfigurator.configure();

		}
	@Override
	public List<DepartmentsModel> retrieveDepartments() {
		List<DepartmentsModel> departmentsModelList=new ArrayList<>();
		try {
			List<Departments> departmentsList=departmentsDAO.getAllDepartments();
			for(Departments department:departmentsList) {
				DepartmentsModel departmentsModel=new DepartmentsModel();
				departmentsModel.setDepartmentId(department.getDepartmentId());
				departmentsModel.setDepartmentName(department.getDepartmentName());
				departmentsModel.setManagerId(department.getManagerId());
				//departmentsModel.setLocationId(department.getLocationId());
				departmentsModelList.add(departmentsModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error("!ERROR[Retrieval of Departments failed!!!]");
		}
		return departmentsModelList;
	}
	
	@Override
	public DepartmentsModel getDepartmentById(int departmentId) {
		DepartmentsModel departmentsModel=new DepartmentsModel();
		try {
			List<Departments> departmentsList=departmentsDAO.getAllDepartments();
			
			for(Departments depts:departmentsList) {		
				if(depts.getDepartmentId()==departmentId) 
				{
					departmentsModel.setDepartmentId(depts.getDepartmentId());
					departmentsModel.setDepartmentName(depts.getDepartmentName());
					departmentsModel.setManagerId(depts.getManagerId());
					//departmentsModel.setLocationId(depts.getLocationId());
					
					break;
				}
				
			}	
		} catch (ClassNotFoundException | SQLException e) {
	          log.error(e);		
		}
		return departmentsModel;
	}
	@Override
	public String registerdepartment(DepartmentsModel model) {
		Departments departments=new Departments();
		departments.setDepartmentId(model.getDepartmentId());
		departments.setDepartmentName(model.getDepartmentName());
		System.out.println(departments);
		//departments.setManagerId(model.getManagerId());
		//departments.setLocationId(model.getLocationId());
		String result=RESULTFORFAILURE;
		boolean stored=departmentsDAO.storeDeptDetails(departments);
		if(stored)
			result=RESULTFORSUCCESS;
		return result;
	}
	@Override
	public String updateDepartment(DepartmentsModel model) throws ClassNotFoundException, SQLException {
		Departments departments=new Departments();
		departments.setDepartmentId(model.getDepartmentId());
		departments.setDepartmentName(model.getDepartmentName());
		departments.setManagerId(model.getManagerId());
		//departments.setLocationId(model.getLocationId());
		String result=RESULTFORFAILURE;
		boolean updated=departmentsDAO.updateEmployee(departments);
		if(updated)
			result="success";
		return result;
	}
	@Override
	public String deleteDepartment(DepartmentsModel departmentsModel) throws ClassNotFoundException, SQLException {
		
		List<Departments> deptList= departmentsDAO.getAllDepartments();
		String result=RESULTFORFAILURE;
		boolean deptFound=false;
		Departments departments=new Departments();
		for(Departments dept: deptList) {
			if(dept.getDepartmentId()==departmentsModel.getDepartmentId()) {
				departments.setDepartmentId(departmentsModel.getDepartmentId());
				deptFound=true;
				break;
			}
		}
		if(deptFound) {
		
			boolean deleted=departmentsDAO.deleteDepartmentDetails(departments);
			if(deleted)
				{result=RESULTFORSUCCESS;}
				else {
					result=RESULTFORFAILURE;
				}
		
		}
		return result;
	}
}