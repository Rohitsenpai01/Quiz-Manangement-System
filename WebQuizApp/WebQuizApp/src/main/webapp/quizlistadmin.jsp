<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="ql" class="com.app.beans.QuizListBean"/>
    ${ql.getQuizzes()}

    <div class="container mt-5">

        <div class="card shadow-sm p-4">

            <h4 class="text-center mb-4">Quiz List</h4>

            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Quiz ID</th>
                            <th>Title</th>
                            <th>Creator ID</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="quiz" items="${ql.quizList}">
                            <tr>
                                <td>${quiz.quiz_id}</td>
                                <td>${quiz.title}</td>
                                <td>${quiz.creator_id}</td>
                                <td>
                                    <a href="deletequiz.jsp?quiz_id=${quiz.quiz_id}" class="btn btn-sm btn-danger">
                                        Delete Quiz
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="text-center mt-3">
                <a href="admin.jsp" class="btn btn-outline-secondary">
                    Back
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
