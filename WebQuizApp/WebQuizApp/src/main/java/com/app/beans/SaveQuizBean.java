package com.app.beans;

import com.app.daos.QuizDao;
import com.app.daos.QuizDaoImp;
import com.app.pojos.Quiz;

public class SaveQuizBean {
	private int quizId;
	private String title;
	private Integer creator_id;
	private int count;
	public SaveQuizBean() {
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(Integer creator_id) {
		this.creator_id = creator_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void addQuiz() {
		try(QuizDao quizDao = new QuizDaoImp()) {
			Quiz q = new Quiz(quizId, title, creator_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
