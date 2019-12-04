<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
hi
<form method="POST" action="/submit">
    <label>Your Name: </label><input type="text" name="name">
    <label>Dojo Location: </label>
    <select name="dojo">
  <option value="Oakland">Oakland</option>
  <option value="San Jose">San Jose</option>
  <option value="Chicago">Chicago</option>
</select>
    
    <label>Favorite Language: </label>
    <select name="lang">
  <option value="python">python</option>
  <option value="java">java</option>
  <option value="R">R</option>
</select>
    <label>Comment (optional): </label><textarea name="comment"></textarea>
    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>