<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 450px;">

            <h4 class="mb-4">Student Registration</h4>

            <jsp:useBean id="rp" class="com.app.beans.RegisterBean"/>
            <jsp:setProperty name="rp" property="*"/>
            <jsp:setProperty name="rp" property="flag" value="false"/>
            <jsp:setProperty name="rp" property="role" value="Student"/>
            ${rp.registerStudent()}

            <c:choose>
                <c:when test="${rp.regStatus}">
                    <h6 class="text-success mb-3">
                        Student Registration is Successful
                    </h6>

                    <a href="index.jsp" class="btn btn-primary">
                        Login Again
                    </a>
                </c:when>

                <c:otherwise>
                    <h6 class="text-danger mb-3">
                        Student Registration is Failed
                    </h6>

                    <div class="d-flex justify-content-center gap-2">
                        <a href="newstudent.jsp" class="btn btn-outline-primary">
                            Register Again
                        </a>
                        <a href="index.jsp" class="btn btn-outline-secondary">
                            Go To Login
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
