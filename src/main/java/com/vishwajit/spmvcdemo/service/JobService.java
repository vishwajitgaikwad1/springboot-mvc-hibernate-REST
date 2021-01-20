package com.vishwajit.spmvcdemo.service;

import java.util.List;

import com.vishwajit.spmvcdemo.model.JobModel;

public interface JobService {
	
	public List<JobModel> findAll();
	
	public JobModel findById(int theId);
	
	public void save(JobModel job);
	
	public void deleteById(int theId);

}
