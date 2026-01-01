<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${initParam.appTitle}</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">


<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <jsp:useBean id="lp" class="com.app.beans.LoginBean" scope="session"/>

    <div class="container mt-4">
        <h1 class="text-center fw-bold">
            ${initParam.appTitle}
        </h1>
        <hr>
    </div>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4" style="width: 360px;">

            <h5 class="text-center mb-4">
                Welcome, <strong>${lp.user.name}</strong>
            </h5>

            <div class="d-grid gap-2">
                <a href="createquiz.jsp" class="btn btn-outline-primary">
                    Create Quiz
                </a>

                <a href="quizlistadmin.jsp" class="btn btn-outline-success">
                    List Quizzes
                </a>

                <a href="viewresult.jsp" class="btn btn-outline-warning">
                    View Results
                </a>

                <a href="logout.jsp" class="btn btn-outline-danger">
                    Logout
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
