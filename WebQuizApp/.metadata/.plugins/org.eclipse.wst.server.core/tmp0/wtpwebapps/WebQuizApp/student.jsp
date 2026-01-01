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
	<jsp:useBean id="lp" class="com.app.beans.LoginBean" scope="session"/>
	<div style="text-align: center;">
		<h4>Welcome, ${lp.user.name}</h4>
		<button><a href="quizlist.jsp">View Quizzes</a></button><br><br>
		<button><a href="viewscore.jsp?user_id=${lp.user.id}">View Scores</a></button><br><br>
		<button><a href="logout.jsp">Logout</a></button>
	</div>
</body>
</html>