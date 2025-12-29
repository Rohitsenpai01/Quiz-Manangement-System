package com.app.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.User;

public class UserDaoImp extends Dao implements UserDao{
	private PreparedStatement stmtFindByEmail;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtSave;
	
	public UserDaoImp() throws Exception {
		stmtFindByEmail = con.prepareStatement("SELECT * FROM USERS WHERE email=?");
		stmtFindById = con.prepareStatement("SELECT * FROM USERS WHERE user_id=?");
		stmtFindAll = con.prepareStatement("SELECT * FROM USERS");
		stmtSave = con.prepareStatement("INSERT INTO USERS() VALUES ()");
	}

	public void close() throws Exception {
		stmtFindByEmail.close();
		stmtFindById.close();
		stmtFindAll.close();
		stmtSave.close();
		super.close();
	}
	
	@Override
	public User findByEmail(String email) throws Exception {
		stmtFindByEmail.setString(1, email);	
		try(ResultSet rs = stmtFindByEmail.executeQuery()) {
			if(rs.next()) {
				int uid = rs.getInt("user_id");
				String name = rs.getString("name");
				email = rs.getString("email");
				String passwd = rs.getString("password_hash");
				String role = rs.getString("role");
				User user = new User(uid, name, email, passwd, null, role);
				return user;
			}
		}
		return null;
	}

	@Override
	public User findById(int user_id) throws Exception {
		stmtFindById.setInt(1, user_id);	
		try(ResultSet rs = stmtFindByEmail.executeQuery()) {
			if(rs.next()) {
				user_id = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String passwd = rs.getString("password_hash");
				String role = rs.getString("role");
				User user = new User(user_id, name, email, passwd, null, role);
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> list = new ArrayList<>();
		try(ResultSet rs = stmtFindAll.executeQuery()) {
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String passwd = rs.getString("password_hash");
				String role = rs.getString("role");
				User user = new User(user_id, name, email, passwd, null, role);
				list.add(user);
			}
		}
		return list;
	}

	@Override
	public int save(User u) throws Exception {
		stmtSave.setInt(1, u.getId());
		stmtSave.setString(2, u.getName());
		stmtSave.setString(3, u.getEmail());
		stmtSave.setString(4, u.getPassword());
		stmtSave.setString(5, u.getRole());
		int us = stmtSave.executeUpdate();
		return us;
	}
	
	
}
