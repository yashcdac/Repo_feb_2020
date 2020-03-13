package com.yash.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.yash.entities.Jobs;
import com.yash.integrate.ConnectionManager;
public class JDBCJobsDAOImpl implements JobsDAO {
	@Override
	public List<Jobs> getAllJobs() throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from jobs");
		List<Jobs> jobsList=new ArrayList<>();
		while(resultSet.next()){
			Jobs jobs=new Jobs();
			jobs.setJobId(resultSet.getString("job_id"));
			jobs.setJobTitle(resultSet.getString("job_title"));
			jobs.setMaxSalary(resultSet.getDouble("max_salary"));
			jobs.setMinSalary(resultSet.getDouble("min_salary"));
			jobsList.add(jobs);
		}
		ConnectionManager.closeConnection();
		return jobsList;
	  }

	@Override
	public Jobs getJobsByJobId(String jobId) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from jobs where job_id=?");
		
		preparedStatement.setString(1, jobId);
		
		
		ResultSet resultSet=
				preparedStatement.executeQuery();
		Jobs jobs=new Jobs();
		while(resultSet.next()){
			
			jobs.setJobId(resultSet.getString("job_id"));
			jobs.setJobTitle(resultSet.getString("job_title"));
			jobs.setMaxSalary(resultSet.getDouble("max_salary"));
			jobs.setMinSalary(resultSet.getDouble("min_salary"));
			
		}
		ConnectionManager.closeConnection();
		
		return jobs;
	}

	@Override
	public boolean createJob(Jobs job) throws ClassNotFoundException, SQLException {
		boolean ifJobStored=false;
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("insert into jobs values(?,?,?,?)");
		statement.setString(1,job.getJobId());
		statement.setString(2,job.getJobTitle());
		statement.setDouble(3, job.getMaxSalary());
		statement.setDouble(4, job.getMinSalary());
		
		
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0) {
			ifJobStored= true;}
		return ifJobStored;
	}

	@Override
	public boolean updateJob(Jobs job) throws ClassNotFoundException, SQLException {
		boolean ifJobUpdated=false;
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update jobs set job_title=?, max_salary=?, min_salary=? where job_id=?");
		
		statement.setString(1, job.getJobTitle());
		statement.setDouble(2, job.getMaxSalary());
		statement.setDouble(3, job.getMinSalary());
		statement.setString(4,job.getJobId());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0) {
			ifJobUpdated=true;}
	    return ifJobUpdated;
	}

	@Override
	public boolean deleteJob(String jobId) throws ClassNotFoundException, SQLException {
		boolean ifJobDeleted=false;
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("delete from jobs where job_id=?");
		statement.setString(1, jobId);
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0) {
			ifJobDeleted= true;}
	   return ifJobDeleted;
	}
	}