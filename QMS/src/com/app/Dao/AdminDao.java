package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.util.DbUtil;

public class AdminDao implements AutoCloseable{
	private Connection con =null;
	
	public AdminDao() throws SQLException{
		con = DbUtil.getConnection();
	}
	
	public boolean adminLogin(String email , String pass , String role) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE email = ? AND password_hash = ? AND role = ?";
		try (PreparedStatement st= con.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, pass);
			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			rs.close();
			st.close();
		}
		return false;
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
