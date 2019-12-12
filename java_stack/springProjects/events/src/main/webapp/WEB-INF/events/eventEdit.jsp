<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.first_name}" /></h1>
	<a href="/logout">Logout</a>
	
    <p><c:out value="${error}" /></p>
    <p><form:errors path="event.*"/></p>
    
    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
    	<input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
        </p>
        <p>
            <form:label path="cityString">Location:</form:label>
            <form:input path="cityString"/>
        </p>
        <p>
        <form:select path="stateString">
                    <form:option value="AL">Alabama</form:option>
                    <form:option value="AK">Alaska</form:option>
                    <form:option value="AZ">Arizona</form:option>
                    <form:option value="AR">Arkansas</form:option>
                    <form:option value="CA">California</form:option>
                    <form:option value="CO">Colorado</form:option>
                    <form:option value="CT">Connecticut</form:option>
                    <form:option value="DE">Delaware</form:option>
                    <form:option value="DC">District Of Columbia</form:option>
                    <form:option value="FL">Florida</form:option>
                    <form:option value="GA">Georgia</form:option>
                    <form:option value="HI">Hawaii</form:option>
                    <form:option value="ID">Idaho</form:option>
                    <form:option value="IL">Illinois</form:option>
                    <form:option value="IN">Indiana</form:option>
                    <form:option value="IA">Iowa</form:option>
                    <form:option value="KS">Kansas</form:option>
                    <form:option value="KY">Kentucky</form:option>
                    <form:option value="LA">Louisiana</form:option>
                    <form:option value="ME">Maine</form:option>
                    <form:option value="MD">Maryland</form:option>
                    <form:option value="MA">Massachusetts</form:option>
                    <form:option value="MI">Michigan</form:option>
                    <form:option value="MN">Minnesota</form:option>
                    <form:option value="MS">Mississippi</form:option>
                    <form:option value="MO">Missouri</form:option>
                    <form:option value="MT">Montana</form:option>
                    <form:option value="NE">Nebraska</form:option>
                    <form:option value="NV">Nevada</form:option>
                    <form:option value="NH">New Hampshire</form:option>
                    <form:option value="NJ">New Jersey</form:option>
                    <form:option value="NM">New Mexico</form:option>
                    <form:option value="NY">New York</form:option>
                    <form:option value="NC">North Carolina</form:option>
                    <form:option value="ND">North Dakota</form:option>
                    <form:option value="OH">Ohio</form:option>
                    <form:option value="OK">Oklahoma</form:option>
                    <form:option value="OR">Oregon</form:option>
                    <form:option value="PA">Pennsylvania</form:option>
                    <form:option value="RI">Rhode Island</form:option>
                    <form:option value="SC">South Carolina</form:option>
                    <form:option value="SD">South Dakota</form:option>
                    <form:option value="TN">Tennessee</form:option>
                    <form:option value="TX">Texas</form:option>
                    <form:option value="UT">Utah</form:option>
                    <form:option value="VT">Vermont</form:option>
                    <form:option value="VA">Virginia</form:option>
                    <form:option value="WA">Washington</form:option>
                    <form:option value="WV">West Virginia</form:option>
                    <form:option value="WI">Wisconsin</form:option>
                    <form:option value="WY">Wyoming</form:option>
                </form:select>
            </p>
        
        <input type="submit" value="Update"/>
    </form:form>
</body>
</html>