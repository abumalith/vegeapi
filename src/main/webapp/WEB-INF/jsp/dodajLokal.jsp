<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj lokal</title>
</head>
<body>
<br>
<p>Dodaj lokal: </p>
<form:form action="/dodajLokal" method="POST" modelAttribute="lokal">
<div><label> Nazwa: <input type="text" name="name" /></label></div>
<div><label> Ulica: <input type="text" name="street" /></label></div>
<div><label> Nr ulicy: <input type="text" name="streetNumber" /></label></div>
<div><label> Telefon: <input type="text" name="tel" /></label></div>
<div><label> Website: <input type="text" name="website" /></label></div>
<div><input type="submit" value="Dodaj"/></div>
</form:form>
</body>
</html>