package com.yash.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
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
import com.yash.validation.EmployeesModelValidator;

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
		if(action.contentEquals("insert"))
		{
			loadForm(request, response);
		}
		
	}

	protected void loadForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void newEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}