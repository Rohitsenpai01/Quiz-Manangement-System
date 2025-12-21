package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.Dao.AdminDao;
import com.app.menu.AdminMenu;

public class AdminService {
	private static AdminMenu edm = new AdminMenu();

	
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
