package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.app.DButil.DbUtil;
import com.app.entity.Quiz;

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
	
	public int insert(Quiz q) throws SQLException{
		String sql =" insert into quizzes (title, creator_id) values (?,?)";
		try(PreparedStatement ps =
				con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1,q.title);
			ps.setInt(2,q.creater_id);
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next());
			return rs.getInt(1);
		}
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
