<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.first_name}" /></h1>
	<a href="/logout">Logout</a>
	
	<h1><c:out value="${event.name }"/></h1>
	<h3><c:out value="${event.date}"/></h3>
	<h3><c:out value="${event.location.city}"/> <c:out value="${event.location.state }"/></h3>
	<h3>People who are attending this event: <c:out value="${num_attendees}"/></h3>
<table>
<thead>
<tr>
<th>Name</th>
<th>Location</th>
</tr>
</thead>
<tbody>
<c:forEach items="${event.attendees }" var="attendee">
<tr>
<td><c:out value="${attendee.first_name }"/> <c:out value="${attendee.last_name }"/></td>
<td><c:out value="${attendee.location.city}"/></td>
</tr>
</c:forEach>
</tbody>
</table>

<h2>Message Wall</h2>
<c:forEach items="${events_messages}" var="msg">
<c:out value="${msg[1].message}"/>
<br>
</c:forEach>
<p>Add Comment:</p>
<form:form action="/events/add/${event.id}" method="POST" modelAttribute="message">
<form:label path="message"></form:label>
<form:input path="message"/>

<input type="submit" value="Submit"/>
</form:form>
</body>
</html>