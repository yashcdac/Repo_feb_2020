package com.yash.dao;
import java.sql.SQLException;
import java.util.List;
import com.yash.entities.Jobs;
public interface JobsDAO {
	public List<Jobs> getAllJobs() throws ClassNotFoundException,SQLException;
	public Jobs  getJobsByJobId(String jobId) throws ClassNotFoundException, SQLException;
	public boolean createJob(Jobs job) throws ClassNotFoundException, SQLException;
	public boolean updateJob(Jobs job) throws ClassNotFoundException, SQLException;
	public boolean deleteJob(String jobId) throws ClassNotFoundException, SQLException;
}
