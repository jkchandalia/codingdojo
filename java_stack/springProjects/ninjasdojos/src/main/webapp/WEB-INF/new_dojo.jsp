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
<form:form action="/create_dojo" method="post" modelAttribute="dojo">
    
    <p>
    <form:label path="name">Name: </form:label>
	<form:errors path="name" />
	<form:input path="name" />
	</p>
	<p>
    <form:label path="tagString">Tags: </form:label>
	<form:errors path="tagString" />
	<form:input path="tagString" />
	</p>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>