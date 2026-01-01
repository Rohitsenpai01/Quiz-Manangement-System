package com.app.daos;

import java.util.List;

import com.app.pojos.Attempts;

public interface AttemptDao extends AutoCloseable{
	List<Attempts> findAll() throws Exception;
	List<Attempts> findStudentById(int user_id) throws Exception;
	public void insertAttempt(int qid, int stuId, int score, int totalQue) throws Exception;
}
