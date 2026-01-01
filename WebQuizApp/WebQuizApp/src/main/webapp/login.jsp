<%@page import="com.app.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="lp" class="com.app.beans.LoginBean" scope="session"/>
    <jsp:setProperty name="lp" property="*"/>
    ${lp.autheticate()}

    <c:choose>

        <c:when test="${empty lp.user}">
            <div class="container d-flex justify-content-center mt-5">
                <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 400px;">

                    <h5 class="text-danger mb-2">Login Failed</h5>
                    <p class="text-muted mb-4">Invalid email or password</p>

                    <a href="index.jsp" class="btn btn-primary">
                        Login Again
                    </a>

                </div>
            </div>
        </c:when>

        <c:when test="${lp.user.role == 'Admin'}">
            <c:redirect url="admin.jsp"/>
        </c:when>

        <c:otherwise>
            <c:redirect url="student.jsp"/>
        </c:otherwise>

    </c:choose>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
