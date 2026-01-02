package com.app.daos;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Quiz;

public interface QuestionDao extends AutoCloseable{
	List<Question> getAll() throws Exception;
	List<Question> getById(int quiz_id) throws Exception;
	void insert(Question qs,Quiz q) throws Exception;
}
