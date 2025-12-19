package com.app.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.Dao.*;
import com.app.entity.*;
import com.app.menu.AdminMenu;
import com.app.util.QuestionFileParser;

public class AdminService {
	private static AdminMenu edm = new AdminMenu();

	// Admin login
	public static void adminLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Admin";
		try (AdminDao ed = new AdminDao()) {
			if (ed.adminLogin(email, pass , role)) {
				System.out.print("Login Successfull...");
				edm.adminMenu(sc);
			} else {
				System.out.println("Login failed !");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void addQuizService(Scanner sc) throws Exception {
		System.out.println("Enter Quiz Title: ");
		String title = sc.nextLine();
		System.out.println("Enter Creator ID: ");
		int adminId = sc.nextInt();
		System.out.println("Enter Question File Path: ");
		File file = new File(sc.nextLine());
		Quiz quiz = new Quiz();
		quiz.title = title;
		quiz.creater_id = adminId;
		
		try (QuizDao quizDao = new QuizDao()) {
			int quizId = quizDao.insert(quiz);
			List<Question> list = QuestionFileParser.parse(file);
					try (QuestionDao questionDao = new QuestionDao()) {
						for (Question q : list) {
							q.quiz_id = quizId;
							questionDao.insert(q); 	
						}
					}
					System.out.println("Quiz Created Successfully with id=" + quizId);
		
		}
	}
	

	public void updateQuizService(Scanner sc) {

	}

	public void deleteService(Scanner sc) {

	}
	public void listQuizService(Scanner sc) {

	}
	public void veiwScoresService(Scanner sc) {

	}

}
