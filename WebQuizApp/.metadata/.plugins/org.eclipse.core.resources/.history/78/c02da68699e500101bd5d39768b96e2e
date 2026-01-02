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
	<jsp:useBean id="fq" class="com.app.beans.FindQuizBean"/>
	<jsp:getProperty name="fq" property="*"/>
	${fq.findQuiz()}
	<form method="post" action="questionlist.jsp">
		<input type="hidden" name="fq" value="${fq.que.quiz_id}">
		<jsp:forward page="questionlist.jsp"/>
	</form>
</body>
</html>