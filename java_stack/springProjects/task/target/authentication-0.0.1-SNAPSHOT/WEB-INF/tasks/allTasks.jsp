<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Tasks</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.name}" /></h1>
<a href="/logout">Logout</a>

	
	
<table>
	<thead>
	<tr>
	<th>Task</th>
	<th>Creator</th>
	<th>Assignee</th>
	<th>Priority</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${tasks}" var="task">
	<tr>
	<td><a href="/tasks/${task.id}"><c:out value="${task.msg }" /></a></td>
	<td><c:out value="${task.creator.name }" /></td>
	<td><c:out value="${task.assignee.name}" /></td>
	<td><c:out value="${task.priority }" /></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
<a href="/tasks/new">Create Task</a>
</body>
</html>