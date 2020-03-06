package com.yash.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.yash.converter.DateConverter;
import com.yash.helper.FactoryEmployeeDB;
import com.yash.model.AllEmployeesModel;
import com.yash.model.DepartmentsModel;
import com.yash.model.EmployeesModel;
import com.yash.model.JobsModel;
import com.yash.model.ManagersModel;
import com.yash.service.DepartmentsService;
import com.yash.service.EmployeesService;
import com.yash.service.JobsService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static EmployeesService employeeService = null;
	private static DepartmentsService departmentService = null;
	private static JobsService jobsService = null;

	private static final String DEPARTMENT_LIST_NAME = "departmentsList";
	private static final String JOB_LIST_NAME = "jobsList";
	private static final String MANAGER_LIST_NAME = "managersList";
	private static final String SUCCESS = "success";
	private static final String EMPLOYEES_MODEL = "employeesModel";
	private static final String OPERATION = "operation";

	private static final String EMPLOYEE_SUCCESS_PAGE = "employeesuccess.jsp";
	private static final String EMPLOYEE_FAIL_PAGE = "employeefail.jsp";
	private static final String ERROR_PAGE = "error.jsp";

	private static final String EMPLOYEE_ID_PARAM = "employeeId";

	static Logger log = Logger.getLogger(EmployeeController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		BasicConfigurator.configure();
	}

	static {
		employeeService = FactoryEmployeeDB.createEmployeesService();
		departmentService = FactoryEmployeeDB.createDepartmentsService();
		jobsService = FactoryEmployeeDB.createJobsService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);
		if (action.contentEquals("insert")) {
			loadForm(request, response);
		}

		if (action.contentEquals("getAllEmployee")) {
			viewEmployee(request, response);
		}
		if (action.contentEquals("getAllDepartment")) {
			getAllDepartment(request, response);
		}
		if (action.contentEquals("getAllJobs")) {
			getAllJobs(request, response);
		}
		if (action.contentEquals("getAllManagers")) {
			getAllManagers(request, response);
		}
		if (action.contentEquals("getEmployeeById")) {
			getEmployee(request, response);
		}

	}

	protected void getAllManagers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().print("View form works");
		List<ManagersModel> managerList = employeeService.getManagers();
		String jsonData;
		try {
			jsonData = JSONObject.valueToString(managerList);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void getAllJobs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().print("View form works");
		List<JobsModel> jobList = jobsService.retrieveJobs();
		String jsonData;
		try {
			jsonData = JSONObject.valueToString(jobList);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	protected void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<EmployeesModel> employeeList = employeeService.retrieveEmployees();
		String jsonData;
		try {
			jsonData = JSONObject.valueToString(employeeList);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	protected void loadForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().print("View form works");
		List<AllEmployeesModel> empList = employeeService.retrieveAllEmployees();
		String jsonData;
		try {
			jsonData = JSONObject.valueToString(empList);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);
		if (action.contentEquals("addEmployee")) {

			newEmployee(request, response);
		}
		if (action.contentEquals("updateEmployee")) {
			updateEmployee(request, response);
		}
		
		if(action.contentEquals("deleteEmployee"))
		{
			try {
				deleteEmployee(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void newEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}

		JSONObject jsonObject;
		AllEmployeesModel model = new AllEmployeesModel();
		try {
			jsonObject = new JSONObject(sb.toString());
			System.out.println(jsonObject.getString("hireDate"));

			int employeeId = jsonObject.getInt("employeeId");
			String firstName = jsonObject.getString("firstName");
			String lastName = jsonObject.getString("lastName");
			String email = jsonObject.getString("email");
			String phoneNumber = jsonObject.getString("phoneNumber");
			// LocalDate localDate=new LocalDate
			LocalDate hireDate = DateConverter.convertLocaleDate(jsonObject.getString("hireDate").substring(0, 10),
					"-");
			// hireDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			// System.out.println(hireDate);
			String jobId = jsonObject.getString("jobId");
			double salary = jsonObject.getDouble("salary");
			double commissionPCT = jsonObject.getDouble("commissionPCT");
			int managerId = jsonObject.getInt("managerId");
			int departmentId = jsonObject.getInt("departmentId");

			model.setEmployeeId(employeeId);
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setEmail(email);
			model.setPhoneNumber(phoneNumber);
			model.setHireDate(hireDate);
			model.setJobId(jobId);
			model.setSalary(salary);
			model.setCommissionPCT(commissionPCT);
			model.setManagerId(managerId);
			model.setDepartmentId(departmentId);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String status = employeeService.registerEmployee(model);
		System.out.println(status);

	}

	protected void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bufferReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferReader.readLine()) != null) {
			sb.append(str);
		}
		;

		try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			AllEmployeesModel e = new AllEmployeesModel();
			e.setEmployeeId(jsonObject.getInt("employeeId"));
			e.setEmail(jsonObject.getString("email"));
			e.setPhoneNumber(jsonObject.getString("phoneNumber"));
			e.setJobId(jsonObject.getString("jobId"));
			e.setDepartmentId(jsonObject.getInt("departmentId"));
			e.setManagerId(jsonObject.getInt("managerId"));
			e.setCommissionPCT(jsonObject.getDouble("managerId"));
			e.setSalary(jsonObject.getDouble("salary"));
			employeeService.updateEmployee(e);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {
		PrintWriter out=response.getWriter();
		
		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jsonObject = new JSONObject(sb.toString());
		int employeeId=jsonObject.getInt("employeeId");
			
				
			
      
    	
    	AllEmployeesModel employeesModel=new AllEmployeesModel();
    	
    	employeesModel.setEmployeeId(employeeId);
    	String outcome=employeeService.deleteEmployee(employeesModel);
    	out.println(jsonObject.getInt("employeeId")+"hii");
    	List<AllEmployeesModel> allEmployeesList=employeeService.retrieveAllEmployees();
    	for(AllEmployeesModel employees:allEmployeesList) {
    		if(employeesModel.getEmployeeId()==employeeId) {
    			employeesModel=employees;
    		}
    	}
    	
				   		
  			
		 
	
	}
}