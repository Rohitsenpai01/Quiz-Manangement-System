package com.app.menu;

import java.util.Scanner;

import com.app.entity.User;
import com.app.service.AdminService;

public class AdminMenu {
	static AdminService as = new AdminService();
	public static int menuOption(Scanner sc) {
		System.out.println("\n1.Create Quiz.");
		System.out.println("2.Update quiz .");
		System.out.println("3.Delete quiz .");
		System.out.println("4.List quiz .");
		System.out.println("5.View Scores .");
		System.out.println("6.Logout ..");
		return sc.nextInt();
	}
	
	public static void adminMenu(Scanner sc ) {
		int choice = 0;
		while ((choice = menuOption(sc))!=6) {
			switch (choice) {
			case 1:
				as.addQuizService(sc, User.id);
				break;
			case 2:
				as.updateQuizService(sc);
				break;
			case 3:
				as.deleteService(sc);
				break;
			case 4:
				as.listQuizService(sc);
				break;
			case 5:
				as.veiwScoresService(sc);
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		}
	}
}
