package com.app.service;

import java.util.List;
import java.util.Scanner;

import com.app.dao.QuizDao;
import com.app.dao.UserDao;
import com.app.model.Quiz;

public class StudentService {
	
	public static void userResistration(Scanner sc) {
		System.out.print("Enter new student name: ");
		String name = sc.next();
		System.out.print("Enter student email: ");
		String email = sc.next();
		System.out.print("Enter the password: ");
		String password = sc.next();
		UserDao.registerUser(name,email, password);
	}
	
	public static boolean authenticateStudent(Scanner sc) {
		System.out.print("Enter Student username: ");
		String username = sc.next();
		System.out.print("Enter Student password: ");
		String password = sc.next();
		if (UserDao.studentLogin(username, password))
			return true;
		return false;
	}
	
	public static void viewQuizzes() {
			System.out.println("\n== All Available Quizzes ==");
			try {
				QuizDao quiz = new QuizDao();			
				List<Quiz> quizList = quiz.getQuizList();
				int i = 1;
				for(Quiz ls : quizList) {
					System.out.println(i + ") " +ls);
					i++;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void takeQuiz() {

	}
	public static void viewScore() {

	}
}
