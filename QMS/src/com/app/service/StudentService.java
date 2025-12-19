package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.Dao.AdminDao;
import com.app.Dao.StudentDao;
import com.app.menu.AdminMenu;

public class StudentService {
	private static AdminMenu edm = new AdminMenu();
	public void stuLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			if (ed.studentLogin(email, pass , role)) {
				System.out.print("Login Successfull...");
//				edm.adminMenu(sc);
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
