package com.vishwajit.spmvcdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.vishwajit.spmvcdemo.model.JobModel;

@Repository
public class JobDAOImpl implements JobDAO {

	private EntityManager entityManager;
	
	@Autowired
	public JobDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<JobModel> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<JobModel> query = currentSession.createQuery("from JobModel",JobModel.class);
		List<JobModel> jobList = query.getResultList();
		return jobList;
	}
	@Override
	public JobModel findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		JobModel job = currentSession.get(JobModel.class, theId);
		return job;
	}
	@Override
	public void save(JobModel theJob) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theJob);
		
	}
	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from JobModel where job_id=:id");
		theQuery.setParameter("id", theId);
		theQuery.executeUpdate();
		
	}

}
