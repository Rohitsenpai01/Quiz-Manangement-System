<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Results</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="vr" class="com.app.beans.AttemptQuizBean"/>
    ${vr.viewresult()}

    <div class="container mt-5">
        <div class="card shadow-sm p-4">

            <h4 class="text-center mb-4">Quiz Results</h4>

            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Attempt ID</th>
                            <th>Quiz ID</th>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Score</th>
                            <th>Total Questions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="at" items="${vr.attemptList}">
                            <tr>
                                <td>${at.id}</td>
                                <td>${at.quiz_id}</td>
                                <td>${at.student_id}</td>
                                <td>${at.student_name}</td>
                                <td>${at.score}</td>
                                <td>${at.total}</td>
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
