<%@page import="com.fbr.entities.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/operate" method="POST" modelAttribute="studt">
	${studt.id }<br>${student.id }
	<c:if test="${studt.id==0 }">
		name:<form:input path="name"/><br>
		<form:hidden path="id"/>
	</c:if>
	<c:if test="${studt.id!=0 }">
		
		<br>
		<form:hidden path="id"/>
		
		<input type="hidden" name="_method" value="PUT">
	</c:if>
	
	
	sex:<form:input path="sex"/><br>
	age:<form:input path="age"/><br>
	phone:<form:input path="phone"/><br>
	<input type="submit" value="Submit"> 
</form:form>
</body>
</html>