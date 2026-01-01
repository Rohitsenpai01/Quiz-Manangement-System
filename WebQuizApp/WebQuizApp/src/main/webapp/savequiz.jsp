<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Quiz</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="sq" class="com.app.beans.SaveQuizBean"/>
    <jsp:setProperty name="sq" property="*"/>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 450px;">

            <c:choose>
                <c:when test="${sq.op == 'add'}">
                    ${sq.addQuiz()}
                    <jsp:forward page="quizlist.jsp">
                        <jsp:param name="msg" value="Quiz Addded: ${sq.count}"/>
                    </jsp:forward>
                </c:when>

                <c:when test="">
                </c:when>
            </c:choose>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
