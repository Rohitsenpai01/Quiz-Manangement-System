package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.Dao.AdminDao;
import com.app.Dao.StudentDao;
import com.app.entity.User;
import com.app.menu.AdminMenu;

public class StudentService {
	public static void stuLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			if (ed.studentLogin(email, pass , role)) {
				System.out.print("Login Successfull...");
			} else {
				System.out.println("Login failed !");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
		public static void  sturegistrationservice(Scanner sc) {
			String name;
			String role = "student";
			String email;
			String password;
			System.out.println("enter name");
			name = sc.next();
			
			System.out.println("enter email :");
			email = sc.next();

		    System.out.println("enter password");
			password = sc.next();
			
			try(StudentDao dao =new StudentDao();){
				if(dao.studentRegister(name, email, password, role)){
					System.out.println("register sucessful");
					
				}else {
					System.out.println("register unsucessful");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	
	
	
	
}
