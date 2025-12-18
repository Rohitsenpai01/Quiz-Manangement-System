package com.tokyo.quizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tokyo.quizapp.model.Quiz;
import com.tokyo.quizapp.util.DbUtil;

public class QuizDao implements AutoCloseable {
private Connection connection = null;
	
	public QuizDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public List<Quiz> getQuizList() throws SQLException {
		List<Quiz> quizList = new ArrayList<>();
		String sql = "SELECT quiz_id, title, creator_id FROM quizzes";
		try (PreparedStatement selectStatement = connection.prepareStatement(sql)) {
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt(1));
				quiz.setTitle(rs.getString(2));
				quiz.setCreater_id(rs.getInt(3));
				quizList.add(quiz);
			}
		}
		return quizList;
	}

	public void createQuiz(Quiz quiz) throws SQLException {
		String sql = "INSERT INTO quizzes (quiz_id, title, creator_id) VALUES (?, ?, ?)";
		try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
			insertStatement.setInt(1, quiz.getId());
			insertStatement.setString(2, quiz.getTitle());
			insertStatement.setInt(3, quiz.getCreater_id());
			insertStatement.executeUpdate();
		}
	}
	
	
	public void close() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
}
