package com.yash.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.yash.dao.JobsDAO;
import com.yash.entities.Employees;
import com.yash.entities.Jobs;
import com.yash.exception.NoEmployeeFoundException;
import com.yash.exception.NoJobFoundException;
import com.yash.exception.SalaryNotValidException;
import com.yash.helper.FactoryEmployeeDB;
import com.yash.model.EmployeesModel;
import com.yash.model.JobsModel;

public class JobsServiceImpl implements JobsService {
	private static final String RESULTFORSUCCESS = "success";
	private static final String RESULTFORFAILURE = "fail";
	static Logger log = Logger.getLogger(JobsServiceImpl.class.getName());

	private JobsDAO jobsDAO;

	public JobsServiceImpl() {
		this.jobsDAO = FactoryEmployeeDB.createJobsDAO();
		BasicConfigurator.configure();
	}

	@Override
	public List<JobsModel> retrieveJobs() {
		List<JobsModel> jobsModelList = new ArrayList<>();
		try {
			List<Jobs> jobsList = jobsDAO.getAllJobs();
			for (Jobs jobs : jobsList) {
				JobsModel jobsModel = new JobsModel();
				jobsModel.setJobId(jobs.getJobId());
				jobsModel.setJobTitle(jobs.getJobTitle());
				jobsModel.setMaxSalary(jobs.getMaxSalary());
				jobsModel.setMinSalary(jobs.getMinSalary());
				jobsModelList.add(jobsModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error("!ERROR[Retrieval of Jobs failed!!!]", e);
		}
		return jobsModelList;
	}

	@Override
	public JobsModel getJobsByJobId(String jobId) {
		JobsModel jobsModel = new JobsModel();

		try {
			Jobs jobs = jobsDAO.getJobsByJobId(jobId);
			jobsModel.setJobId(jobs.getJobId());
			jobsModel.setJobTitle(jobs.getJobTitle());
			jobsModel.setMaxSalary(jobs.getMaxSalary());
			jobsModel.setMinSalary(jobs.getMinSalary());

		} catch (ClassNotFoundException | SQLException e) {
			log.error("!ERROR[Retrieval of Jobs by id failed!!!]", e);
		}
		return jobsModel;
	}

	@Override
	public String createJob(JobsModel jobsModel) {
		Jobs job = new Jobs();
		job.setJobId(jobsModel.getJobId());
		job.setJobTitle(jobsModel.getJobTitle());
		job.setMinSalary(jobsModel.getMinSalary());
		job.setMaxSalary(jobsModel.getMaxSalary());

		String result = RESULTFORFAILURE;
		try {
			System.out.println(job);
			boolean stored = jobsDAO.createJob(job);
			if (stored)
				result = RESULTFORSUCCESS;

		} catch (ClassNotFoundException | SQLException e) {
			log.error("!ERROR[Registration failed because of internal issues...]", e);
		}
		return result;
	}

	@Override
	public String updateJob(JobsModel jobsModel) {
		Jobs job = new Jobs();
		job.setJobId(jobsModel.getJobId());
		job.setJobTitle(jobsModel.getJobTitle());
		job.setMinSalary(jobsModel.getMinSalary());
		job.setMaxSalary(jobsModel.getMaxSalary());
		String result = RESULTFORFAILURE;
		try {
			boolean updated = jobsDAO.updateJob(job);
			if (updated)
				result = "success";
		} catch (ClassNotFoundException | SQLException e) {
			log.error("!ERROR[job updation failed!!]", e);
		}
		return result;
	}

	@Override
	public String deleteJob(String jobId) {
		List<JobsModel> jobModelList = retrieveJobs();
		
		String result = RESULTFORFAILURE;
		boolean jobFound = false;

		for (JobsModel jobsModel : jobModelList) {
			if (jobsModel.getJobId().equals(jobId)) {

				jobFound = true;
				break;
			}
		}
		
		if (jobFound) {
			try {
				boolean deleted = jobsDAO.deleteJob(jobId);
				if (deleted)
					result = RESULTFORSUCCESS;
			} catch (ClassNotFoundException | SQLException e) {
				log.error("!ERROR[job record deletion failed!!]", e);
			}
		} else {
			try {
				throw new NoJobFoundException("job not found");
			} catch (NoJobFoundException e) {
				log.error("!ERROR[job with specified id does not exist!!]", e);
			}
		}
		return result;
	}
}
