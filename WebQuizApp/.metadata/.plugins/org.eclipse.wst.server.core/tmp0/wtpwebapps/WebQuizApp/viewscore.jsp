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
	<jsp:useBean id="vs" class="com.app.beans.AttemptQuizBean" scope="page" />
    <jsp:setProperty name="vs" property="student_id" param="user_id"/>
    <% vs.viewScore(); %>
    <div style="text-align: center;">
        <h2>Quiz Score</h2>
        <c:choose>
            <c:when test="${not empty vs.attemptList}">
                <table border="1" align="center">
                    <thead>
                        <tr>
                            <th>Attempt ID</th>
                            <th>Quiz ID</th>
                            <th>Score</th>
                            <th>Total Questions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="atc" items="${vs.attemptList}">
                            <tr>
                                <td>${atc.id}</td>
                                <td>${atc.quiz_id}</td>
                                <td>${atc.score}</td>
                                <td>${atc.total}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>No quiz attempts found for this user.</p>
            </c:otherwise>
        </c:choose><br><br>
        <button type="button"><a href="student.jsp">Back</a></button><br>
    </div>
</body>
</html>