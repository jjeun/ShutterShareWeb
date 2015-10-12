<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: home.jsp (java server page) - Renders the homepage for the website utilizing
			jstl (java server page tag library) and Spring attributes passed by the controller. 
 -->
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="row" items="${users}">
    ID: ${row.id}<br/>
    Name: ${row.firstName} ${row.lastName}<br/>
    Email: ${row.email}<br/>
    Password: ${row.password}<br/>
</c:forEach>

</body>
</html>