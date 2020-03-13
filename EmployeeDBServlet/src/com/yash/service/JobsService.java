package com.yash.service;

import java.util.List;

import com.yash.model.JobsModel;

public interface JobsService {
	public List<JobsModel> retrieveJobs();

	public JobsModel getJobsByJobId(String jobId);

	public String createJob(JobsModel job);

	public String updateJob(JobsModel job);

	public String deleteJob(String jobId);
}
