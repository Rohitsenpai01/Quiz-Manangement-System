package com.app.main;

import java.util.Scanner;

import com.app.menu.*;

public class QuizMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainMenu.getMainMenu(sc);
		sc.close();
	}
	
}
