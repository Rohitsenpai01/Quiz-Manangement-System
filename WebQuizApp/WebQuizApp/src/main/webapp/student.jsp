<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="lp" class="com.app.beans.LoginBean" scope="session"/>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 400px;">

            <h5 class="mb-4">
                Welcome, <strong>${lp.user.name}</strong>
            </h5>

            <div class="d-grid gap-3">
                <a href="quizlist.jsp" class="btn btn-primary">
                    View Quizzes
                </a>

                <a href="viewscore.jsp?user_id=${lp.user.id}" class="btn btn-outline-success">
                    View Scores
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
