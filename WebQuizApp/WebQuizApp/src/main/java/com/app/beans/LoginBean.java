package com.app.beans;

import com.app.daos.UserDao;
import com.app.daos.UserDaoImp;
import com.app.pojos.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	public LoginBean() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void autheticate() {
		try(UserDao userDao = new UserDaoImp()) {
			User dbUser = userDao.findByEmail(email);
			if(dbUser != null && dbUser.getPassword().equals(passwd))
				this.user = dbUser;
			else 
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
