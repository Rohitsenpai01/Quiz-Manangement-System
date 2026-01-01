<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cqc" class="com.app.beans.CreateQuizBean" scope="page"/>
<jsp:setProperty name="cqc" property="title" param="title"/>
<jsp:setProperty name="cqc" property="path" param="path"/>
<jsp:setProperty name="cqc" property="creator_id" param="user_id"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Processing Quiz .</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 500px;">

            <c:choose>
                <c:when test="${cqc.createQuizz()}">
                    <h5 class="text-success mb-3">
                        Quiz and questions imported successfully!
                    </h5>

                    <a href="admin.jsp" class="btn btn-primary">
                        Back
                    </a>
                </c:when>

                <c:otherwise>
                    <h5 class="text-danger mb-3">
                        Failed to create quiz
                    </h5>

                    <p class="text-muted mb-4">
                        Please check if the file path is correct and the file format is valid.
                    </p>

                    <div class="d-flex justify-content-center gap-2">
                        <a href="createquiz.jsp" class="btn btn-outline-primary">
                            Try Again
                        </a>
                        <a href="admin.jsp" class="btn btn-outline-secondary">
                            Back to Dashboard
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
