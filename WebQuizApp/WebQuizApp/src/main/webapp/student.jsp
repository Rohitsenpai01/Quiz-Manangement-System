<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1 style="text-align: center;">${initParam.appTitle}</h1><hr><br>
	<div style="text-align: center;">
		<button><a href="listquizzes.jsp">View Quizzes</a></button><br><br>
		<button><a href="takequiz.jsp">Take Quiz</a></button><br><br>
		<button><a href="viewscore.jsp">View Scores</a></button><br><br>
		<button><a href="logout.jsp">Logout</a></button>
	</div>
</body>
</html>