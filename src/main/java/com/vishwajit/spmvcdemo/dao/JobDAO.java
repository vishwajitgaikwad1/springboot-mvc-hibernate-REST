package com.vishwajit.spmvcdemo.dao;

import java.util.List;

import com.vishwajit.spmvcdemo.model.JobModel;

public interface JobDAO {

	public List<JobModel> findAll();
	
	public JobModel findById(int theId);
	
	public void save(JobModel job);
	
	public void deleteById(int theId);
}
