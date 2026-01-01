<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.app.beans.LoginBean"></jsp:useBean>
	<jsp:setProperty property="*" name="lb"/>
	${lb.isAvailable()}
	name :${lb.user.name}
	<c:choose>
		
		<c:when test="${empty lb.user}">
			<h3>login failed</h3>
		</c:when>
		<c:when test="${lb.user.role == 'Admin'}">
				<c:redirect url = "admin.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<c:redirect url ="student.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>