package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.Question;
import com.app.util.DbUtil;

public class QuestionDao implements AutoCloseable{
	public Connection con = null;
	
	public QuestionDao() throws SQLException {
		con = DbUtil.getConnection();
	}
	
	public List<Question> getAllStudentModels() throws SQLException {
		List<Question> queList = new ArrayList<>();
		String sql = "SELECT question_id, quiz_id, text, a, b, c, d FROM questions";
		try (PreparedStatement selectStatement = con.prepareStatement(sql)) {
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				Question que = new Question();
				que.setId(rs.getInt(1));
				que.setText(rs.getString(2));
				que.setA(rs.getString(3));
				que.setB(rs.getString(4));
				que.setC(rs.getString(5));
				que.setD(rs.getString(6));
				queList.add(que);
			}
		}
		return queList;
	}
	
	public void insert (Question q) throws Exception {
		String sql = "INSERT INTO questions " + "(quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, q.quiz_id);
			ps.setString(2, q.text);
			ps.setString(3,q.a);
			ps.setString(3,q.b);
			ps.setString(3,q.c);
			ps.setString(3,q.d);
			ps.executeUpdate();
		}
	}
	
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	
}
