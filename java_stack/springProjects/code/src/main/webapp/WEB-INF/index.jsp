<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<meta charset="UTF-8">
<title>Code</title>
</head>
<body>
<span class="red"><c:out value="${error }" /></span>
<form method="POST" action="/testcode">
    <label>What is the Code?</label>
    <input type="text" name="code">
    <input type="submit" value="Try Code">
</form>
</body>
</html>