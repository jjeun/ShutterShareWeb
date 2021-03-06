<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>ShutterShare - Home</title>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
<script type="text/javascript">

$(document).on("click", "#delete", function () {
    var eventCode = $(this).data('id');
    $(".modal-body #eventCode").val( eventCode );
    // As pointed out in comments, 
    // it is superfluous to have to manually call the modal.
    // $('#addBookDialog').modal('show');
});

</script> 



</head>
<body>


	<!-- this is the navigation bar up top -->
	<div class="navbar navbar-default navbar-custom navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<img class="navbar-brand"
					src="${pageContext.request.contextPath}/resources/images/greenlogo.png"
					alt="shuttersharelogo">
				<button id="navbutton" class="navbar-toggle" data-toggle="collapse"
					data-target=".navHeaderCollapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/settings">Account</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Log
							out</a></li>
				</ul>

			</div>
		</div>


	</div>
	<!-- navigation bar ends-->
	<center>
		<img
			src="${pageContext.request.contextPath}/resources/images/orangelogo.png"
			class="img-responsive" id="orangelogo" alt="orangelogo">
	</center>

	<!-- welcome box -->
	<br />
	<br />
	<div class="container">
		<div class="jumbotron">
			<center>
				<h1 id="welcome">
					Welcome,
					<c:out value="${users[0].firstName}"></c:out>!
				</h1>
				<br /> <a href="${pageContext.request.contextPath}/createevent"
					class="btn btn-primary">Create a New Event</a>
			</center>
		</div>
	</div>
	<br />


	<!--show events-->
	<center>
		<c:if test="${empty events}">
			<p>You have no events created.</p>
		</c:if>
		<c:if test="${!empty events}">
			<p>You have events!</p>
			<br />
			<br />
		</c:if>
	</center>

	<c:if test="${!empty events}">
		<div class="container">
			<center>


				<div class="row">
					<c:forEach var="event" items="${events}">
						<div class="col-sm-4">
							<p id="eventcode">Event: ${event.description}</p>
							<p id="eventcode">Event Code: ${event.eventCode}</p>
							<p id="event1">
								<a href="${pageContext.request.contextPath}/eventpics?eventcode=${event.eventCode}&description=${event.description}">
								<img src="${pageContext.request.contextPath}/resources/images/orangeshuttericon.png"
									alt="ShutterShare Pictures" height="90%" width="90%"></a>
							</p>
						
							&nbsp;
							&nbsp;
							
							<a href="#deletepopup" data-toggle="modal" data-id="${event.eventCode}" class = "btn btn-delete delete" id="delete" type="submit">Delete Event</a>
						
						</div>
					</c:forEach>
				</div>

			</center>
		</div>
	</c:if>
	
	
 	<div class="modal fade" id="deletepopup">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="model-header">
						<h4>Delete Event</h4>
					</div>
					<div class="modal-body">
						<center>
						<p>Are you sure you want to delete this event?</p><br />
						
						<form action="${pageContext.request.contextPath}/" method="post">	
							<button class = "btn-small btn-delete delete" id="no" type="submit">NO</button>
						</form> 
						
						<form action="${pageContext.request.contextPath}/deleteevent" method="post">	
							<input type="hidden" value="" id= "eventCode" name="eventCode" />
							<button class = "btn-small btn-delete delete" id="yes" type="submit">YES</button>
						</form> 
						</center>
					</div>
				</div>
			</div>
		</div>
			 

</body>
</html>