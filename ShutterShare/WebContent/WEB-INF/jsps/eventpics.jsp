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



<title>ShutterShare - Event Pictures</title>
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
    var picture = $(this).data('id');
    $(".modal-body #picture").val( picture );

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
	<%-- <center>
		<img
			src="${pageContext.request.contextPath}/resources/images/orangelogo.png"
			class="img-responsive" id="orangelogo" alt="orangelogo">
	</center> --%>

	<!-- welcome box -->
	<br />
	<br />
	<div class="container">
		<div class="jumbotron">
			<center>
				<h1 id="welcome">
					<c:out value="${description} Picture Gallery"></c:out>
				</h1>
				 
			</center>
		</div>
	</div>

	<div class="container">
		<center>

			<div class="row">
				<c:forEach var="pic" items="${pictures}">
					<div class="col-sm-4">
						<p id="eventcode">Taken By: ${pic.uploader}</p>
						<p id="event1">
							<a href="http://52.27.86.208/uploads/${pic.picture}">
							<img src="http://52.27.86.208/uploads/${pic.picture}"
								alt="ShutterShare Pictures" height="100%" width="100%"></a>
						</p>
						
						&nbsp;
						&nbsp;
						
						<a href="http://52.27.86.208/uploads/${pic.picture}" download="${pic.picture}">
							<button class="btn-small btn-delete delete" id="delete"
								type="submit">Download Picture</button></a><br>
								
						<a href="#deletepopup" data-toggle="modal" data-id="${pic.picture}" 
							class = "btn btn-delete delete" id="delete" type="submit">Delete Picture</a>
						
					</div>
				</c:forEach>
			</div>

		</center>
	</div>
	
	 	<div class="modal fade" id="deletepopup">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="model-header">
						<h4>Delete Event</h4>
					</div>
					<div class="modal-body">
						<center>
						<p>Are you sure you want to delete this event?</p><br />
						<form action="${pageContext.request.contextPath}/eventpics" method="post">
							<input type="hidden" value="" id= "picture" name="picture" />
							<input type="hidden" value="${description}" id= "description" name="description" />
							<input type="hidden" value="${pictures[0].code}" id= "eventcode" name="eventcode" />
							<button class = "btn-small btn-delete delete" id="no" type="submit">NO</button>
						</form>
					
						<form action="${pageContext.request.contextPath}/deletepic" method="post">
							<input type="hidden" value="" id= "picture" name="picture" />
							<input type="hidden" value="${description}" id= "description" name="description" />
							<input type="hidden" value="${pictures[0].code}" id= "eventCode" name="eventCode" />
							<button class = "btn-small btn-delete delete" id="yes" type="submit">YES</button>
						</form> 
						</center>
					</div>
				</div>
			</div>
		</div>


</body>
</html>