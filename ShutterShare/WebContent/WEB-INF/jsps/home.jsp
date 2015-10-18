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
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type='text/css'/> 
<title>Insert title here</title>
</head>
<body>

	<p>
		<a href="${pageContext.request.contextPath}/createevent">Create a
			New Event</a>
	</p>


	<c:if test="${events == null}">
	You have no events created.<br />
	</c:if>
	
	<c:if test="${events != null}">
	You have events!<br />
		<table>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/eventpictures">${event.description}</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>