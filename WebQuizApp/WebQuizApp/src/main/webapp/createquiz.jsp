<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Quiz</title>

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
        <div class="card shadow-sm p-4" style="width: 100%; max-width: 420px;">

            <h4 class="text-center mb-4">Create Quiz</h4>

            <form method="post" action="createquizcatch.jsp">

                <div class="mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" name="title" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Path</label>
                    <input type="text" name="path" class="form-control" required>
                </div>

                <input type="hidden" name="user_id" value="${lp.user.id}">

                <div class="d-grid">
                    <input type="submit" value="Submit" class="btn btn-primary">
                </div>

            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
