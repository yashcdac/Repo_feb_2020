package com.yash.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.yash.helper.FactoryEmployeeDB;
import com.yash.model.AllEmployeesModel;
import com.yash.model.DepartmentsModel;
import com.yash.service.DepartmentsService;


@WebServlet("/department")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static DepartmentsService departmentService = null;
	
	static Logger log = Logger.getLogger(DepartmentController.class.getName());
    public DepartmentController() {
        super();
        BasicConfigurator.configure();
    }
    
    static {
		
		departmentService = FactoryEmployeeDB.createDepartmentsService();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.contentEquals("getAllDepartments")) {
			getAllDepartment(request, response);
		}
		if (action.contentEquals("getDepartmentById")) {
			getDepartmentById(request, response);
		}
	}

	protected void getAllDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().print("View form works");
		List<DepartmentsModel> deptList = departmentService.retrieveDepartments();
		String jsonData;
		try {
			jsonData = JSONObject.valueToString(deptList);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getDepartmentById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("departmentId"));
		System.out.println(id);
		DepartmentsModel dept=departmentService.getDepartmentById(id);
		System.out.println(dept);
	
	
		String jsonData;
		try {
			List<DepartmentsModel>l=new ArrayList<>();
			l.add(dept);
			jsonData = JSONObject.valueToString(l);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.contentEquals("addDepartment"))
		{
			newDepartment(request, response);
		}
		if(action.contentEquals("updateDepartment"))
		{
			try {
				updateDepartment(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.contentEquals("deleteDepartment"))
		{
			try {
				deleteDepartment(request, response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, ClassNotFoundException, SQLException {
		PrintWriter out=response.getWriter();
		
		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		
		JSONObject jsonObject = new JSONObject(sb.toString());
		int departmentId=jsonObject.getInt("departmentId");
		//out.println(jsonObject.getInt("employeeId")+"hii");
		
		DepartmentsModel departmentsModel=new DepartmentsModel();
		departmentsModel.setDepartmentId(departmentId);
    	out.println(departmentsModel);
    	String outcome=departmentService.deleteDepartment(departmentsModel);	   
		
	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		BufferedReader bufferReader = request.getReader();
		StringBuilder sb=new StringBuilder();
		String str=null;
		while ((str=bufferReader.readLine())!=null) {
			sb.append(str);
		};
		
		try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			DepartmentsModel e=new DepartmentsModel();
			e.setDepartmentId(jsonObject.getInt("departmentId"));
			e.setDepartmentName(jsonObject.getString("departmentName"));
			e.setManagerId(jsonObject.getInt("managerId"));
			System.out.println(e);
			//e.setLocationId(jsonObject.getInt("locationId"));
			departmentService.updateDepartment(e);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void newDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		int departmentId=0;
		String departmentName=null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		
			JSONObject jsonObject;
			DepartmentsModel model=new DepartmentsModel();
			try {
				jsonObject = new JSONObject(sb.toString());
				
				
				departmentId = jsonObject.getInt("departmentId");
				departmentName = jsonObject.getString("departmentName");
				
				model.setDepartmentId(departmentId);
				model.setDepartmentName(departmentName);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String status=departmentService.registerdepartment(model);
			System.out.println(status);
			response.getWriter().write("department inserted with id "+departmentId);

		
		
	}

}
