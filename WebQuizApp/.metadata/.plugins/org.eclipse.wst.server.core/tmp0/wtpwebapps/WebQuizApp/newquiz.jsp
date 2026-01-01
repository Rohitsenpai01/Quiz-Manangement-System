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
		<form method="post" action="savequiz.jsp">
			<input type="hidden" name="quizId" value="0">
			Title <input type="text" name="title"/> <br/><br/>
			Path <input type="text" name="path"/> <br/><br/>
			<input type="hidden" name="op" value="add"/>
			<input type="submit" value="Add Quiz"/>
		</form>
	</div>
</body>
</html>