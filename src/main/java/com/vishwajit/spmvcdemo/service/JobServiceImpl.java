package com.vishwajit.spmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishwajit.spmvcdemo.dao.JobDAO;
import com.vishwajit.spmvcdemo.model.JobModel;

@Service
public class JobServiceImpl implements JobService {

	
	private JobDAO jobDAO;
	
	@Autowired
	public JobServiceImpl(JobDAO theJobDAO) {
		jobDAO = theJobDAO;
	}
	
	@Override
	@Transactional
	public List<JobModel> findAll() {
		// TODO Auto-generated method stub
		return jobDAO.findAll();
	}

	@Override
	@Transactional
	public JobModel findById(int theId) {
		// TODO Auto-generated method stub
		return jobDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(JobModel job) {
		jobDAO.save(job);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		jobDAO.deleteById(theId);

	}

}
