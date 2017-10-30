<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zaloguj się:</title>
</head>
<body>
<p>${message}</p>
<br>
<p>Zaloguj się: </p>
<form:form action="/login" method="POST" modelAttribute="user">
<div><label> User: <input type="text" name="username" /></label></div>
<div><label> Password: <input type="password" name="password"/> </label></div>
<div><input type="submit" value="Sign In"/></div>
</form:form>
</body>
</html>