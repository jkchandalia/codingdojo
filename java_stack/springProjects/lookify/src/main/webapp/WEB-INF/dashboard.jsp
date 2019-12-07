<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/songs/new">Add New</a>
<a href="/search/topten">Top Songs</a>
<form action="/searchbar" method="post">
<input type="text" name="artist">
<input type="submit" value="Search Artists">
</form>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td>
            <form action="/songs/${lang.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="delete">
			</form> 
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>