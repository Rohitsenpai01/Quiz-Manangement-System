package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entity.User;
import com.app.util.DbUtil;

public class AdminDao implements AutoCloseable{
	private static Connection con =null;
	
	public static int adId;
	
	public AdminDao() throws SQLException{
		con = DbUtil.getConnection();
	}
	
	public static User adminLogin(String email , String pass ) throws SQLException {
		User u = new User();
		String sql = "SELECT * FROM USERS WHERE email = ? AND password_hash = ?";
		try (PreparedStatement st = con.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setRole(rs.getString(5));
				return u;
			}
			rs.close();
			st.close();
		}
		return null;
	}
	
	public List<User> getAllAdmin() throws SQLException{
		List<User> adminList = new ArrayList<>();
		String sql = "SELECT user_id,name,email,password_hash FROM USERS WHERE role = ADMIN";
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
				adminList.add(a);
			}
		}
		return adminList;
	}
	
	public List<User> getAdminId() throws SQLException{
		List<User> adIdList = new ArrayList<>();
		String sql = "SELECT user_id FROM USERS";
		return adIdList;
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
