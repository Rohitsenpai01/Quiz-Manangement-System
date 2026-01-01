<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Score</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="vs" class="com.app.beans.AttemptQuizBean" scope="page"/>
    <jsp:setProperty name="vs" property="student_id" param="user_id"/>
    <% vs.viewScore(); %>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width:100%; max-width:600px;">

            <h4 class="mb-4">Quiz Score</h4>

            <c:choose>
                <c:when test="${not empty vs.attemptList}">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover align-middle">
                            <thead class="table-light">
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
                    </div>
                </c:when>

                <c:otherwise>
                    <p class="text-muted">No quiz attempts found for this user.</p>
                </c:otherwise>
            </c:choose>

            <div class="mt-3">
                <a href="student.jsp" class="btn btn-outline-secondary">
                    Back
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
