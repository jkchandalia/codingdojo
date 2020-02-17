<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body>
<h1>Create a new task</h1>

<p><form:errors path="task.*"/></p>
<form:form method="POST" action="/tasks/new" modelAttribute="task">
        <p>
            <form:label path="msg">Task:</form:label>
            <form:input path="msg"/>
        </p>
        <p>
        <form:select path="assignee_id" >
			<c:forEach items="${users}" var="user">
				<form:option value="${user.id}">
					<c:out value="${user.name}"/>
				</form:option>
			</c:forEach>
		</form:select>
		</p>
        <p>
        <form:select path="priority">
                    <form:option value="High">High</form:option>
                    <form:option value="Medium">Medium</form:option>
                    <form:option value="Low">Low</form:option>
        </form:select>
        </p>
        
        <input type="submit" value="Create!"/>
    </form:form>
    
</body>
</html>