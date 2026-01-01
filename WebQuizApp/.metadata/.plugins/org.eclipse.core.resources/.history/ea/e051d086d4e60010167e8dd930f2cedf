<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h4>Hello, ${lp.user.name}</h4>
		<button><a href="createquiz.jsp">Create Quiz</a></button><br><br>
		<button><a href="quizlistadmin.jsp">List Quizzes</a></button><br><br>
		<button><a href="viewresult.jsp">View Results</a></button><br><br>
		<button><a href="logout.jsp">Logout</a></button>
	</div>
</body>
</html>