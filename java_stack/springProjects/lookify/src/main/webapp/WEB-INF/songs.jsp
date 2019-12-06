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

Title: <c:out value="${asong.title}"/>
Artist: <c:out value="${asong.artist}"/>
Rating(1-10): <c:out value="${asong.rating}"/>
<form action="/songs/${asong.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="delete">
			</form> 
<a href="/dashboard">Dashboard</a>
</body>
</html>