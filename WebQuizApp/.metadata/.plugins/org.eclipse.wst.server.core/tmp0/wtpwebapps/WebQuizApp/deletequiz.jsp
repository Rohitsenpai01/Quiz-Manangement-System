<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1 style="text-align: center;">${initParam.appTitle}</h1><hr><br>
	<div style="text-align: center;">
		<jsp:useBean id="dq" class="com.app.beans.FindQuizBean"/>
		<jsp:setProperty name="dq" property="quiz_id" param="quiz_id"/>
		${dq.findQuiz()}
		${dq.deleteQuiz()}
		<h4>Quiz Deleted Successfully</h4>
		<button type="button"><a href="quizlistadmin.jsp">Back</a></button><br>
	</div>
</body>
</html>