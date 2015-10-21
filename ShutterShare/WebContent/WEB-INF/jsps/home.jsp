<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" type='text/css' />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>	
<script type="text/javascript">

function onDeleteClick(){

	var doDelete = confirm("Are you sure you want to delete this event?");
	
	if (doDelete == false){
		event.preventDefault();
	}
}


function ready(){
	$("#delete").click(onDeleteClick);
	
}


$(document).ready(ready)

</script>


<title>ShutterShare - Home</title>
</head>
<body>


	<p>
		<a href="${pageContext.request.contextPath}/logout">Logout of
			ShutterShare</a>
	</p>

	<p>
		Welcome
		<c:out value="${users[0].firstName}"></c:out>
		!<br />
	</p>

	<p>
		<a href="${pageContext.request.contextPath}/createevent">Create a
			New Event</a>
	</p>


	<c:if test="${empty events}">
	You have no events created.<br />
	</c:if>

	<c:if test="${!empty events}">
	You have events!<br />
		<table>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/eventpictures">${event.description}</a></td>
					
					<td><form action="${pageContext.request.contextPath}/deleteevent" method="post">
					<input type="hidden" value="${event.eventCode}" name="eventCode" />
						<button id="delete" class="delete" type="submit">Delete Event</button>
					</form></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>