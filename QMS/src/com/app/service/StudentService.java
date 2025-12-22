package com.app.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.Dao.QuizDao;
import com.app.Dao.StudentDao;
import com.app.entity.Quiz;
import com.app.menu.StudentMenu;

public class StudentService {
	private static StudentMenu sm = new StudentMenu();
	public void stuLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			if (ed.studentLogin(email, pass, role)) {
				sm.studentMenu(sc);
				System.out.print("Student Login Successfull...");
			} else {
				System.out.println("Student Login Failed !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public void stuRegisterService(Scanner sc) {
		String name, email, pass;
		System.out.print("Enter Name -");
		name = sc.next();
		System.out.print("Enter Email -");
		email = sc.next();
		System.out.print("Enter Pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			ed.studentRegister(name, email, pass , role); 
			System.out.println("Student Register Successfully...");
		} catch (SQLException e) {
			System.out.println("Student Registration Failed !");
			e.printStackTrace();
		} catch (Exception e1) {
			System.out.println("Student Registration Failed !");
			e1.printStackTrace();
		}
	}
	
	public static void listQuizService() {
		try (QuizDao qDao = new QuizDao()) {
			List<Quiz> quizlist = qDao.getQuizList();
			for(Quiz q : quizlist ) {
				System.out.print("\nQuiz ID: " + q.getId());
				System.out.print("\tTitle: " + q.getTitle());
				System.out.print("\tCreator ID: " + q.getCreater_id());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeQuizService(Scanner sc) {
		
	}
}
