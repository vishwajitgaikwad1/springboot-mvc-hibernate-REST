package com.vishwajit.spmvcdemo.dao;

import java.util.List;

import com.vishwajit.spmvcdemo.model.LoginModel;

public interface LoginDAO {
	
	public boolean validateLogin(String username, String password);

	List<LoginModel> get();

}
