package com.tokyo.quizapp.main;

import java.util.Scanner;

import com.tokyo.quizapp.menu.MainMenu;

public class MainQuiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainMenu.mainMenuWithEnum(sc);
		sc.close();
	}

}
