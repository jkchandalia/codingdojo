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
<h1>New License</h1>
<form:form action="/create_license" method="post" modelAttribute="license">
    
    <p>
    <form:label path="person">Person: </form:label>
	<form:errors path="person" />
	<form:select path="person" >
			<c:forEach items="${persons}" var="person">
				<form:option value="${person.id}">
					<c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/>
				</form:option>
			<c:out value="${person.first_name}"/>
			</c:forEach>
	</form:select>
	</p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="exp_date">Expiration Date</form:label>
        <form:errors path="exp_date"/>
        <form:input type="date" path="exp_date"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    
</body>
</html>