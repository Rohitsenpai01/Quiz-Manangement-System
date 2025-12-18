package com.tokyo.quizapp.menu;

import java.util.Scanner;

enum EMainMenu {
	AdminLogin, StudentRegister, StudentLogin, Exit
}

public class MainMenu {
	public static void mainMenuWithEnum(Scanner sc) {
		EMainMenu[] arr = EMainMenu.values();
		EMainMenu enumChoice;
		do {
			for (EMainMenu elememt : arr)
				System.out.println(elememt.ordinal()+". "+elememt.name());
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			enumChoice = arr[choice];
			switch (enumChoice) {
			case AdminLogin:
				AdminMenu.adminMenuOptions(sc);
				break;
			case StudentRegister:
				
				break;
			case StudentLogin:
				
				break;
			case Exit:
				System.out.println("Signing Out");
				break;
			default:
				System.out.println("Wrong Choice. Try Again.");
				break;
			}
		} while (enumChoice != EMainMenu.Exit);
	}
}
