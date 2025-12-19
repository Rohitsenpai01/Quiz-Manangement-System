package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entity.*;
import com.app.util.DbUtil;

public class QuizDao implements AutoCloseable {
private Connection con = null;
	
	public QuizDao() throws SQLException {
		con = DbUtil.getConnection();
	}
	
	public List<Quiz> getQuizList() throws SQLException {
		List<Quiz> quizList = new ArrayList<>();
		String sql = "SELECT quiz_id, title, creator_id FROM quizzes";
		try (PreparedStatement selectStatement = con.prepareStatement(sql)) {
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
		try (PreparedStatement insertStatement = con.prepareStatement(sql)) {
			insertStatement.setInt(1, quiz.getId());
			insertStatement.setString(2, quiz.getTitle());
			insertStatement.setInt(3, quiz.getCreater_id());
			insertStatement.executeUpdate();
		}
	}
	
	public void removeQuiz(Scanner sc) {
		System.out.println("Enter the Rollno: ");
		int rollno = sc.nextInt();
		try(QuizDao quizDao = new QuizDao()) {
			System.out.println("Student Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	//					INSERT QUIZ AND USING FILE ADDED HERE
	public int insert(Quiz q) throws SQLException {
		String sql = "INSERT INTO quizzes (title, creator_id) VALLUES (?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, q.title);
			ps.setInt(2, q.creater_id);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
				return rs.getInt(1);
		}
		return 0;
	}
	
	public void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
