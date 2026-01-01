<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="fq" class="com.app.beans.FindQuizBean"/>
    <jsp:getProperty name="fq" property="*"/>
    ${fq.findQuiz()}

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width: 100%; max-width: 400px;">

            <h5 class="mb-3">Loading Quiz Questions</h5>

            <form method="post" action="questionlist.jsp">
                <input type="hidden" name="fq" value="${fq.que.quiz_id}">
                <jsp:forward page="questionlist.jsp"/>
            </form>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
