package com.app.entity;

import java.time.LocalDate;

public class User {

	/*
	 * +---------------+-------------------------+------+-----+-------------------+-------------------+
| Field         | Type                    | Null | Key | Default           | Extra             |
+---------------+-------------------------+------+-----+-------------------+-------------------+
| user_id       | int                     | NO   | PRI | NULL              | auto_increment    |
| name          | varchar(50)             | NO   |     | NULL              |                   |
| email         | varchar(50)             | YES  | UNI | NULL              |                   |
| password_hash | varchar(255)            | YES  |     | NULL              |                   |
| created_at    | timestamp               | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| role          | enum('Admin','Student') | YES  |     | Student           |                   |
+---------------+-------------------------+------+-----+-------------------+-------------------+
	 */
	
	private int id;
	private String name;
	private String email;
	private String password;
	private LocalDate created_at;
	private String role;
	
}
