package com.app.daos;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Quiz;
import com.app.util.QuestionFileParser;

public class QuizDaoImp extends Dao implements QuizDao{

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtDeleteById;
	private PreparedStatement stmtCreateQuiz;
	private PreparedStatement stmtInsertQuiz;
	
	public QuizDaoImp() throws Exception {
		stmtFindAll = con.prepareStatement("SELECT * FROM quizzes");
		stmtFindById =  con.prepareStatement("SELECT * FROM quizzes WHERE quiz_id = ?");
		stmtDeleteById = con.prepareStatement("DELETE FROM quizzes WHERE quiz_id = ?");
		stmtInsertQuiz = con.prepareStatement("INSERT INTO quizzes (title, creator_id) VALUES (?, ?)");
		stmtCreateQuiz = con.prepareStatement("");
	}

	public void close() throws Exception {
		stmtFindAll.close();
		stmtFindById.close();
		stmtDeleteById.close();
		stmtInsertQuiz.close();
		stmtCreateQuiz.close();
		super.close();
	}
	
	@Override
	public List<Quiz> findAll() throws Exception {
		List<Quiz> list = new ArrayList<>();
		try(ResultSet rs = stmtFindAll.executeQuery()) {
			while(rs.next()) {
				int quiz_id = rs.getInt("quiz_id");
				String title = rs.getString("title");
				int creator_id = rs.getInt("creator_id");
				Quiz q = new Quiz(quiz_id, title, creator_id);
				list.add(q);
			}
		}
		return list;
	}

	@Override
	public Quiz findById(int quiz_id) throws Exception {
		stmtFindById.setInt(1, quiz_id);
		try(ResultSet rs = stmtFindById.executeQuery()) {
			if(rs.next()) {
				quiz_id = rs.getInt("quiz_id");
				String title = rs.getString("title");
				int creator_id = rs.getInt("creator_id");
				Quiz q = new Quiz(quiz_id, title, creator_id);
				return q;
			}
		}
		return null;
	}

	@Override
	public int deleteById(int quiz_id) throws Exception {
		stmtDeleteById.setInt(1, quiz_id);
		int count = stmtDeleteById.executeUpdate();
		return count;
	}

	@Override
	public int insert(Quiz q) throws Exception {
	    // Modified to return the auto-generated quiz_id
	    try (PreparedStatement ps = con.prepareStatement(
	            "INSERT INTO quizzes (title, creator_id) VALUES (?, ?)", 
	            java.sql.Statement.RETURN_GENERATED_KEYS)) {
	        ps.setString(1, q.getTitle());
	        ps.setInt(2, q.getCreator_id());
	        ps.executeUpdate();
	        
	        try (ResultSet rs = ps.getGeneratedKeys()) {
	            if (rs.next()) {
	                return rs.getInt(1); // Return the new quiz_id
	            }
	        }
	    }
	    return -1;
	}
	
	@Override
	public boolean createQuiz(Quiz q, String path) throws Exception {
	    File file = new File(path);
	    // 1. Insert the quiz and get the ID
	    int generatedId = this.insert(q); 
	    
	    if (generatedId != -1) {
	        // 2. Parse the file into questions
	        List<Question> list = QuestionFileParser.parse(file);
	        
	        // 3. Save questions using the generated ID
	        try (QuestionDao queDao = new QuestionDaoImp()) {
	            for (Question qs : list) {
	                qs.setQuiz_id(generatedId); // Set FK
	                queDao.insert(qs, q); 
	            }
	            return true;
	        }
	    }
	    return false;
	}
}
