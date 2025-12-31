package com.app.beans;

import com.app.daos.UserDao;
import com.app.daos.UserDaoImp;
import com.app.pojos.User;

public class RegisterBean {
	private String name;
	private String email;
	private String passwd;
	private String role;
	private boolean regStatus, flag;

	public RegisterBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isRegStatus() {
		return regStatus;
	}

	public void setRegStatus(boolean regStatus) {
		this.regStatus = regStatus;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void registerStudent() {
		try(UserDao userDao = new UserDaoImp()) {
			User user = new User(0, name, email, passwd, null, role);
			int count = userDao.save(user);
			this.regStatus = count == 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
