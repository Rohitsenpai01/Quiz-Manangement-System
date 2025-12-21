package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.DButil.DbUtil;

public class StudentDao implements AutoCloseable {
private Connection con =null;
	
	public StudentDao() throws SQLException{
		con = DbUtil.getConnection();
	}
	
	public boolean studentLogin(String email , String pass , String role) throws SQLException {
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
	public boolean studentRegister(String name ,String email , String pass , String role) throws SQLException {
		String sql = "INSERT INTO USERS(name , email , password_hash , role) VALUES(?,?,?,?)";
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
	
	public void close() throws SQLException {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
