package com.vishwajit.spmvcdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class LoginModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	

	@NotEmpty(message="Username is required!")
	@Column(name="user_name")
	private String username;
	
	@NotNull(message="Password is required!")//@NotNull works with initbinder, so @NotEmpty is used , it makes use of @NotNull isValid()
	@Size(min=4, message="Enter valid password!")
	@Column(name="user_password")
	private String password;
	
	@Override
	public String toString() {
		return "LoginModel [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public LoginModel() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
