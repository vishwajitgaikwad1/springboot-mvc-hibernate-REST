package com.vishwajit.spmvcdemo.service;

import java.util.List;

import com.vishwajit.spmvcdemo.model.LoginModel;

public interface LoginService {
	
	public boolean validateLogin(String username, String password);
	
	List<LoginModel> get();

}
