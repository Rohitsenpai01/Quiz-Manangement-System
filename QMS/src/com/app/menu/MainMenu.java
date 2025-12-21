package com.app.menu;

import java.util.Scanner;

import com.app.service.AdminService;
import com.app.service.StudentService;

public class MainMenu {
	


	public static int menuOption(Scanner sc) {
		System.out.println("\n\n==========================");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Registration");
		System.out.println("3.Student Log in");
		System.out.println("4.Exit...");
		System.out.println("==========================");
		return sc.nextInt();
	}
	
	public static void mainMenu(Scanner sc ) {
		int choice = 0;
		while ((choice = menuOption(sc))!=4) {
			switch (choice) {
			case 1:AdminService.adminLoginService(sc);
				break;
			case 2:StudentService.sturegistrationservice(sc);
				break;
			case 3:StudentService.stuLoginService(sc);
				break;
			case 4:System.out.println("exit");
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		}
	}
	
}
