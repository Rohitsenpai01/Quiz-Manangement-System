package com.app.util;

import java.io.*;
import java.util.*;
import com.app.pojos.Question;

public class QuestionFileParser {

    public static List<Question> parse(File path) throws Exception {
        List<Question> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            String q = null, a = null, b = null, c = null, d = null;
            char ans = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    if (q != null) {
                        list.add(new Question(0, 0, q, a, b, c, d, ans));
                    }
                    q = a = b = c = d = null; 
                    ans = 0;
                    continue;
                }
                if (q == null) {
                    q = line;
                } else if (line.matches("^[A-D][).].*")) {
                    char ch = line.toUpperCase().charAt(0);
                    String val = line.substring(2).trim();
                    if (ch == 'A') a = val;
                    else if (ch == 'B') b = val;
                    else if (ch == 'C') c = val;
                    else if (ch == 'D') d = val;
                } else if (line.startsWith("ANSWER: ")) {
                    ans = line.substring(8).trim().charAt(0);
                }
            }
            if (q != null) {
                list.add(new Question(0, 0, q, a, b, c, d, ans));
            }
        }
        return list;
    }
}