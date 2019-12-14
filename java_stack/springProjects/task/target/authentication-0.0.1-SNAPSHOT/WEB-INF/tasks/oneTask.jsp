<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>
<h1>Task: <c:out value="${task.msg}"/></h1>
<p>Creator: <c:out value="${task.creator.name}"/></p>
<p>Assignee: <c:out value="${task.assignee.name}"/></p>
<p>Priority: <c:out value="${task.priority}"/></p>
<c:if test="${task.creator.id==user.id}">
<a href="/tasks/${task.id}/edit">Edit</a> 
<form action="/tasks/${task.id}/delete" method="POST">
	<input type="hidden" name="_method" value="delete">
	<input type="submit" value="Delete">
</c:if>

<c:if test="${task.assignee.id==user.id}"> 
<form action="/tasks/${task.id}/delete" method="POST">
	<input type="hidden" name="_method" value="delete">
	<input type="submit" value="Completed">
</c:if>
</form>
</body>
</html>