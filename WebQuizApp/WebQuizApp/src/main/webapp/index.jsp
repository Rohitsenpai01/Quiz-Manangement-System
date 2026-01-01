<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4" style="width: 100%; max-width: 400px;">

            <form method="post" action="login.jsp">

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" name="email" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="passwd" class="form-control" required>
                </div>

                <div class="d-grid mb-3">
                    <input type="submit" value="Login" class="btn btn-primary">
                </div>

                <div class="text-center">
                    <a href="newstudent.jsp" class="btn btn-outline-secondary">
                        Signup
                    </a>
                </div>

            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
