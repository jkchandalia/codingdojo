<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h1>New Person</h1>
<form:form action="/create_person" method="post" modelAttribute="person">
    <p>
        <form:label path="first_name">First Name</form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
    <p>
        <form:label path="last_name">Last Name</form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    
</body>
</body>
</html>