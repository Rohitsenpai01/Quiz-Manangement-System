package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	
	//createQuiz
	public int insert(Quiz q)throws SQLException{
		String sql = "Insert Into quizzes (title , creator_id) , VALUES (?,?)";
		try(PreparedStatement st= con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS)){
			st.setString(1, q.title);
			st.setInt(2, q.creater_id);
			st.executeQuery();
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}
	}
	
	//updateQuiz
//	public int update(Quiz q)throws SQLException{
//		String sql = "Insert Into quizzes (title , creator_id) , VALUES (?,?)";
//		try(PreparedStatement st= con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS)){
//			st.setString(1, q.title);
//			st.setInt(2, q.creater_id);
//			st.executeQuery();
//			
//			ResultSet rs = st.getGeneratedKeys();
//			if(rs.next()) {
//				return rs.getInt(1);
//			}
//			return 0;
//		}
//	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
