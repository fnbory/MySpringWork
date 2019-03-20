<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${studnt.id }
<c:if test="${!empty requestScope.students }">
	<c:forEach items="${requestScope.students }" var="student">
		<c:out value="${student}"></c:out>
		<a href="delete/${student.id}">delete</a>
		<a href="update/${student.id}">update</a><br>
	</c:forEach>
	<a href="insert">insert</a>
</c:if>
success
</body>
</html>