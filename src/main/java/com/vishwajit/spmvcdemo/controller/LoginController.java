package com.vishwajit.spmvcdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vishwajit.spmvcdemo.model.LoginModel;
import com.vishwajit.spmvcdemo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	 @RequestMapping("/index")
	 public String index(Model model) {
		 
		 LoginModel login = new LoginModel();
		 model.addAttribute("login",login);
	     return "index";
	     
	   }
	
	 @RequestMapping("/homepage")
	 public String showHomePage(@Valid @ModelAttribute("login") LoginModel login, BindingResult theBindingResult, Model model) 
	 {
		 if(theBindingResult.hasErrors())
		 {
			 return "index";
		 }
		 else
		 {
			 boolean isUserValid = loginService.validateLogin(login.getUsername(), login.getPassword());
			 if(isUserValid==true)
			 {
				 System.out.println("Validate User:"+login.toString());
				 model.addAttribute("errormessage","No User Found!");
				 
				 List<LoginModel> loginModel = loginService.get();
				 System.out.println(loginModel);
				 model.addAttribute("userList",loginModel);
				 return "home";
			 }
			 else
			 {
			 return "index";
			 }
			 
		 }	 
		 
		 
	 }
	 
	 

}
