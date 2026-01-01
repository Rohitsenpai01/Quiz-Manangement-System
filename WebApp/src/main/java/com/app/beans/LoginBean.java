package com.app.beans;

import java.sql.SQLException;

import com.app.Dao.AdminDao;
import com.app.entity.User;

public class LoginBean {
	String pass , email;
	User user;
	
	
	public LoginBean() {
		
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void isAvailable() {
		try {
			AdminDao ad = new AdminDao();
			user = ad.adminLogin(email, pass);
			System.out.println(user.getName());
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
