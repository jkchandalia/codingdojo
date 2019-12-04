<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/date.js"></script>
<meta charset="UTF-8">
<title>Display Date</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<span class="blue"><c:out value="${date}" /></span>
</body>
</html>