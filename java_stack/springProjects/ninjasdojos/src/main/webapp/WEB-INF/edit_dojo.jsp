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
<c:out value="${dojo.name}" />
<form:form action="/add_tag/${dojo.id}" method="post" modelAttribute="tag">
    <p>
    <form:label path="id">Add Tag: </form:label>
	<form:errors path="id" />
	<form:select path="id" >
			<c:forEach items="${other_tags}" var="tag">
				<form:option value="${tag.id}">
					<c:out value="${tag.tag}"/>
				</form:option>
			</c:forEach>
	</form:select>
	</p>
	<input type="submit" value="Add Tag"/>
	</form:form>
	
<form:form action="/add_tag2" method="post" modelAttribute="tag">
    
    <p>
    <form:label path="tag">Add Tag: </form:label>
	<form:errors path="tag" />
	<c:forEach items="${other_tags}" var="other_tag">
	<form:checkbox path="tag" value="${other_tag.id}" />
	<c:out value="${other_tag.tag}"/>
	</c:forEach>	
	</p>
	<input type="submit" value="Add Tag"/>
	</form:form>
</body>
</html>