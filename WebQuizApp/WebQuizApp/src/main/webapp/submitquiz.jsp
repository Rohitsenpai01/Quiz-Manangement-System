<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body style="background-color:${initParam.theme};">

    <div class="container mt-4">
        <h1 class="text-center fw-bold">${initParam.appTitle}</h1>
        <hr>
    </div>

    <jsp:useBean id="quli" class="com.app.beans.QuestionListBean"/>
    <jsp:setProperty name="quli" property="quiz_id" value="${param.quiz_id}"/>
    ${quli.fetchQuestions()}

    <div class="container d-flex justify-content-center mt-5">
        <div class="card shadow-sm p-4 text-center" style="width:100%; max-width:500px;">

            <%
                int score = 0;
                int total = 0;
                java.util.List<com.app.pojos.Question> list = quli.getQuestionList();

                if (list != null) {
                    total = list.size();
                    for (int i = 0; i < total; i++) {
                        String submittedAns = request.getParameter("ans_" + i);
                        char correctAns = list.get(i).getCorrect();
                        if (submittedAns != null && submittedAns.equalsIgnoreCase(String.valueOf(correctAns))) {
                            score++;
                        }
                    }
                }
                request.setAttribute("finalScore", score);
                request.setAttribute("totalQuestions", total);
            %>

            <h5 class="mb-3">Quiz Attempted Successfully</h5>

            <p class="fw-semibold">
                Score: ${finalScore} / ${totalQuestions}
            </p>

            <jsp:useBean id="sa" class="com.app.beans.AttemptQuizBean"/>
            <jsp:setProperty name="sa" property="quiz_id" value="${param.quiz_id}"/>
            <jsp:setProperty name="sa" property="student_id" value="${lp.user.id}"/>
            <jsp:setProperty name="sa" property="score" value="${finalScore}"/>
            <jsp:setProperty name="sa" property="total" value="${totalQuestions}"/>
            ${sa.save()}

            <div class="mt-4">
                <a href="quizlist.jsp" class="btn btn-primary">
                    Back
                </a>
            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
