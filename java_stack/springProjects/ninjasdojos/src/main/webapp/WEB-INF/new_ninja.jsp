<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
<form:form action="/create_ninja" method="post" modelAttribute="ninja">
    
    <p>
    <form:label path="dojo">Dojo: </form:label>
	<form:errors path="dojo" />
	<form:select path="dojo" >
			<c:forEach items="${dojos}" var="dojo">
				<form:option value="${dojo.id}">
					<c:out value="${dojo.name}"/>
				</form:option>
			</c:forEach>
	</form:select>
	</p>
    <p>
        <form:label path="first_name">First Name: </form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
    <p>
        <form:label path="last_name">Last Name: </form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <p>
        <form:label path="age">Age: </form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>