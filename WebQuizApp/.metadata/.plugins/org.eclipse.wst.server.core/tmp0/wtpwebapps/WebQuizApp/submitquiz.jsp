<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Quiz Result</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1 style="text-align: center;">${initParam.appTitle}</h1><hr><br>
	<jsp:useBean id="quli" class="com.app.beans.QuestionListBean" />
	<jsp:setProperty name="quli" property="quiz_id"
		value="${param.quiz_id}" />
	${quli.fetchQuestions()}

	<div style="text-align: center;">
		<%
		int score = 0;
		int total = 0;
		java.util.List<com.app.pojos.Question> list = quli.getQuestionList();

		if (list != null) {
			total = list.size();
			for (int i = 0; i < total; i++) {
				String submittedAns = request.getParameter("ans_" + i);
				char correctAns = list.get(i).getCorrect();
				if (submittedAns != null && submittedAns.equalsIgnoreCase(String.valueOf(correctAns))) {
			score++;
				}
			}
		}
		request.setAttribute("finalScore", score);
		request.setAttribute("totalQuestions", total);
		%>
		<p>Quiz Attempted Successfully</p>
		<jsp:useBean id="sa" class="com.app.beans.AttemptQuizBean" />
		<jsp:setProperty name="sa" property="quiz_id" value="${param.quiz_id}" />
		<jsp:setProperty name="sa" property="student_id" value="${lp.user.id}" />
		<jsp:setProperty name="sa" property="score" value="${finalScore}" />
		<jsp:setProperty name="sa" property="total" value="${totalQuestions}" />
		${sa.save()} <br>
		<button>
			<a href="quizlist.jsp">Back</a>
		</button>
	</div>
</body>
</html>