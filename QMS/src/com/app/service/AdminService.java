package com.app.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.Dao.AdminDao;
import com.app.entity.Question;
import com.app.entity.Quiz;
import com.app.menu.AdminMenu;

public class AdminService {
	private static AdminMenu edm = new AdminMenu();

	// Admin login
	public void adminLoginService(Scanner sc) {
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

	public void addQuizService(Scanner sc , int adminId) {
		System.out.println("Enter Quiz Title :");
		String title = sc.next();
		System.out.println("Enter File Path:");
		File file = new File(sc.next());
		
		Quiz quiz = new Quiz();
		quiz.title = title;
		quiz.creater_id = adminId;
		
//		try(AdminDao qd = new AdminDao() ) {
//			int quizId = qd.insert(quiz);
//			
//			List<Question> list = QuestionFileParser.parse(file);
//			try(QuestionDao qdao = new QuestionDao()){
//				for(Question q : list) {
//					q.quiz_id = 
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
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
