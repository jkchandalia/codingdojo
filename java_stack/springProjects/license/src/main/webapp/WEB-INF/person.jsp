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

        <h2><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h2>
         License Number: <c:out value="${person.license.number}"/>
         State: <c:out value="${person.license.state}"/>
         Expiration Date: <c:out value="${person.license.exp_date}"/>
</table>
</body>
</html>