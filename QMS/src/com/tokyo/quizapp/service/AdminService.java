package com.tokyo.quizapp.service;

import java.sql.SQLException;
import java.util.List;

import com.tokyo.quizapp.dao.QuizDao;
import com.tokyo.quizapp.model.Quiz;

public class AdminService {
	public static void quizListDisplay() {
		try (QuizDao adminDao = new QuizDao()) {
			List<Quiz> quizList = adminDao.getQuizList();
			for (Quiz quiz : quizList) {
				System.out.println("Quiz ID: " + quiz.getId());
				System.out.println("Title: " + quiz.getTitle());
				System.out.println("Creator ID: " + quiz.getCreater_id());
				System.out.println("-----------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createQuiz() {
		
	}
}	
