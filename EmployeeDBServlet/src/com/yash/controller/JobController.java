package com.yash.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.yash.model.JobsModel;
import com.yash.service.JobsService;

@WebServlet("/job")
public class JobController  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private static JobsService jobsService = null;

	

	static Logger log = Logger.getLogger(JobController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobController() {
		super();
		BasicConfigurator.configure();
	}

	static {
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
		

		if (action.contentEquals("getAllJobs")) {
			getAllJobs(request, response);
		}
		
		if (action.contentEquals("getJobById")) {
			getJobById(request, response);
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
	protected void getJobById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobId=request.getParameter("jobId");
		System.out.println(jobId);
		JobsModel jobsModel=jobsService.getJobsByJobId(jobId);
		System.out.println(jobsModel);
	
	
		String jsonData;
		try {
			List<JobsModel>l=new ArrayList<>();
			l.add(jobsModel);
			jsonData = JSONObject.valueToString(l);
			response.setContentType("application/json");
			ServletOutputStream sos = response.getOutputStream();
			sos.write(jsonData.getBytes());
		} catch (JSONException e) {
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
	
		if(action.contentEquals("addJob"))
		{
			newJob(request, response);
		}
		
		if(action.contentEquals("updateJob"))
		{
			updateJob(request, response);
		}
		if(action.contentEquals("deleteJob"))
		{
			try {
				deleteJob(request, response);
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

	protected void newJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("newjOb()");

		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		
			JSONObject jsonObject;
			JobsModel model=new JobsModel();
			try {
				jsonObject = new JSONObject(sb.toString());
				String jobId=jsonObject.getString("jobId");
				String jobTitle=jsonObject.getString("jobTitle");
				double minSalary=jsonObject.getDouble("minSalary");
				double maxSalary=jsonObject.getDouble("maxSalary");
	
				model.setJobId(jobId);
				model.setJobTitle(jobTitle);
				model.setMaxSalary(maxSalary);
				model.setMinSalary(minSalary);
				System.out.println(model);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status=jobsService.createJob(model);
			System.out.println(status);
	}


	protected void updateJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bufferedReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			sb.append(str);
		}
		
			JSONObject jsonObject;
			JobsModel model=new JobsModel();
			try {
				jsonObject = new JSONObject(sb.toString());
				String jobId=jsonObject.getString("jobId");
				String jobTitle=jsonObject.getString("jobTitle");
				double minSalary=jsonObject.getDouble("minSalary");
				double maxSalary=jsonObject.getDouble("maxSalary");
	
				model.setJobId(jobId);
				model.setJobTitle(jobTitle);
				model.setMaxSalary(maxSalary);
				model.setMinSalary(minSalary);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status=jobsService.updateJob(model);
			System.out.println(status);
	}

	 protected void deleteJob(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, JSONException {
		 System.out.println("deleteJob()");
			PrintWriter out=response.getWriter();
			
			BufferedReader bufferedReader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			
			JSONObject jsonObject = new JSONObject(sb.toString());
			String jobId=jsonObject.getString("jobId");
			System.out.println(jobId);
			
	    	String outcome=jobsService.deleteJob(jobId);
	    	System.out.println(outcome);
		}
}