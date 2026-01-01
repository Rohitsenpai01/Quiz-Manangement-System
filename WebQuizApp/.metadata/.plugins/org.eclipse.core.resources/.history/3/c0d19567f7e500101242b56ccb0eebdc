<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 1. Initialize the Bean --%>
<jsp:useBean id="cqc" class="com.app.beans.CreateQuizBean" scope="page"/>

<%-- 2. Automatically map form parameters (title, path, user_id) to Bean properties --%>
<%-- Note: Ensure you added the setUser_id() method in the Bean to map the 'user_id' form field --%>
<jsp:setProperty name="cqc" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Processing Quiz...</title>
</head>
<body bgcolor="${initParam.theme}">
    <h1 style="text-align: center;">${initParam.appTitle}</h1>
    <hr>

    <div style="text-align: center;">
        <c:choose>
            <%-- 3. Execute the creation logic --%>
            <c:when test="${cqc.createQuiz()}">
                <p style="color: green;">Quiz and questions imported successfully!</p>
                <%-- Redirect to admin dashboard on success --%>
                <c:redirect url="admin.jsp"/>
            </c:when>
            
            <c:otherwise>
                <%-- Show error message if something went wrong (e.g., file not found or DB error) --%>
                <h3 style="color: red;">Failed to create quiz.</h3>
                <p>Please check if the file path is correct and the file format is valid.</p>
                <br>
                <a href="createquiz.jsp">Try Again</a> | <a href="admin.jsp">Back to Dashboard</a>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>