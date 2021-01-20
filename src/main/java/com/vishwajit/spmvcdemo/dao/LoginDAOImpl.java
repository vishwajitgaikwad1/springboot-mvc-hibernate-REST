package com.vishwajit.spmvcdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vishwajit.spmvcdemo.model.LoginModel;

@Repository
public class LoginDAOImpl implements LoginDAO {

	//inject sessionFactory
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<LoginModel> get()
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<LoginModel> query = currentSession.createQuery("from LoginModel",LoginModel.class);
		List<LoginModel> userlist = query.getResultList();
		return userlist;
	}
	
	
	@Override	public boolean validateLogin(String username, String password) {
		
		try {
			 Session currentSession = entityManager.unwrap(Session.class);
			 Query query = currentSession.createQuery("from LoginModel u where u.username=:user and u.password=:pass",LoginModel.class);
			// Query<LoginModel> query = currentSession.createQuery("select * from user",LoginModel.class);
			 query.setParameter("user",username);
			 query.setParameter("pass",password);
			 
			 LoginModel user = (LoginModel) query.getSingleResult();
			 if(user.equals(null))
			 {
				 return false;
			 }
			 else
			 {
				 System.out.println(user.getUsername() +" "+ user.getPassword());
				 return true;
			 }
			}
			catch(NoResultException e) {
				e.printStackTrace();
				return false;
			}
	}

}
