<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="${language.name}"/>
<c:out value="${language.creator}"/>
<c:out value="${language.version}"/>
<form action="/languages/${language.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="delete">
			</form> 
			<a href="/languages/edit/${language.id}">edit</a>
<a href="/languages">Dashboard</a>
</body>
</html>