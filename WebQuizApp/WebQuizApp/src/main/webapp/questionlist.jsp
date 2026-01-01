<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attempt Quiz</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <div class="container mt-4">

        <jsp:useBean id="quli" class="com.app.beans.QuestionListBean"/>
        <jsp:setProperty name="quli" property="quiz_id" value="${param.quiz_id}"/>
        ${quli.fetchQuestions()}

        <form method="post" action="submitquiz.jsp">

            <c:forEach var="q" items="${quli.questionList}" varStatus="loop">

                <input type="hidden" name="quiz_id" value="${param.quiz_id}">

                <div class="card shadow-sm mb-4">
                    <div class="card-body">

                        <p class="fw-semibold mb-3">
                            Q${loop.count}. ${q.text}
                        </p>

                        <div class="form-check mb-2">
                            <input class="form-check-input" type="radio" name="ans_${loop.index}" value="A">
                            <label class="form-check-label">${q.a}</label>
                        </div>

                        <div class="form-check mb-2">
                            <input class="form-check-input" type="radio" name="ans_${loop.index}" value="B">
                            <label class="form-check-label">${q.b}</label>
                        </div>

                        <div class="form-check mb-2">
                            <input class="form-check-input" type="radio" name="ans_${loop.index}" value="C">
                            <label class="form-check-label">${q.c}</label>
                        </div>

                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="ans_${loop.index}" value="D">
                            <label class="form-check-label">${q.d}</label>
                        </div>

                    </div>
                </div>

            </c:forEach>

            <div class="d-flex justify-content-center gap-3 mt-4">
                <input type="submit" value="Submit Quiz" class="btn btn-primary">
                <a href="quizlist.jsp" class="btn btn-outline-secondary">Back</a>
            </div>

        </form>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
