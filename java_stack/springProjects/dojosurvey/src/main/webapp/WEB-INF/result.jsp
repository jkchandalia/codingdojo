<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Survey</title>
</head>
<body>
<label>Name:<c:out value="${name }"/></label> 
<label>Dojo:<c:out value="${dojo }"/></label> 
<label>Language:<c:out value="${lang }"/></label> 
<label>Comment:<c:out value="${comment }"/></label> 
</body>
</html>