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
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Tags</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojos}" var="dojo">
        <tr>
            <td><c:out value="${dojo.name}"/></a></td>
            <td><c:forEach items="${dojo.tags}" var="tag">
            <c:out value="${tag.tag}"/>
            </c:forEach>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>