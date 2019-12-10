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
<c:out value="${dojoNinja[0][0].name}" />
<table>
    <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
        <%-- <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
            <td><c:out value="${ninja.first_name}"/></a></td>
            <td><c:out value="${ninja.last_name}"/></td>
            <td><c:out value="${ninja.age}"/></td>
        </tr>
        </c:forEach> --%>
        <c:forEach items="${dojoNinja}" var="dN">
        <tr>
            <td><c:out value="${dN[1].first_name}"/></a></td>
            <td><c:out value="${dN[1].last_name}"/></td>
            <td><c:out value="${dN[1].age}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>