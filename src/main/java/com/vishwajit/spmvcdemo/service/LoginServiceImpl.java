package com.vishwajit.spmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishwajit.spmvcdemo.dao.LoginDAO;
import com.vishwajit.spmvcdemo.model.LoginModel;

@Service
public class LoginServiceImpl implements LoginService {

	//inject DAO
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	@Transactional
	public List<LoginModel> get()
	{
		return loginDAO.get();
	}
	
	@Override
	@Transactional
	public boolean validateLogin(String username, String password) {
		 return loginDAO.validateLogin(username,password);
		
	}

}
