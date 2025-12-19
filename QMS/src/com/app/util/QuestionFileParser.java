package com.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.*;

public class QuestionFileParser {
	public static List<Question> parse(File file) throws Exception {
		List<Question> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Asus\\OneDrive\\Desktop\\Questions.txt"));
		String line, q = null, a = null, b = null, c = null, d = null;
		char correct = 0;
		while((line = br.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				if(q != null) {
					list.add(new Question(0, 0, q, a, b, c, d, correct));
				}
				q = a = b = c = d = null;
				correct = 0;
			}
			if(q == null) q = line;
			else if (line.matches("[A-D][).].*")) {
				char ch = line.charAt(0);
				String val = line.substring(2).trim();
				if(ch == 'A') a = val;
				if(ch == 'B') b = val;
				if(ch == 'C') c = val;
				if(ch == 'D') d = val;
			}
			else if (line.startsWith("ANSWER: ")) {
				correct = line.charAt(7);
			}
		}
		br.close();
		return list;
	}

	public static List<Question> parse(String string) {
		return QuestionFileParser.parse("G:\\Quiz-Manangement-System\\Questions.txt");
	}
}
