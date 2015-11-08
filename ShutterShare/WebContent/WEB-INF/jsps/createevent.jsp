<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create Event</title>
	<meta name="viewport" content="width=device-width, intial-scale=1.0">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<!-- this is the navigation bar up top -->
		<div class = "navbar navbar-default navbar-custom navbar-static-top">
			<div class ="container">
				<div class = "navbar-header">
					<img class = "navbar-brand" src="${pageContext.request.contextPath}/resources/images/greenlogo.png" alt="shuttersharelogo">
						<button id="navbutton" class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
						<span class = "icon-bar"></span>
						<span class = "icon-bar"></span>
						<span class = "icon-bar"></span>
					</button>
				</div>
				<div class = "collapse navbar-collapse navHeaderCollapse">
				<ul class = "nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/settings">Account</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Log
							out</a></li>
				</ul>
			
				</div>
			</div>
		</div>
		<br />
		<!-- navigation bar ends-->
		
		<div class = "container">
		<div class="row">
			<center>
			<fieldset id="createacc">
				<sf:form method="post"
					action="${pageContext.request.contextPath}/docreate"
					commandName="events">
					<center>
					<h4>Create Event</h4><br />
					<table>
						<tr>
							<td class = "formlabel">Event Name:</td>
							<td><sf:input path="description" name="description" type="text"
							placeholer="Create An Event Name" /><br /> <sf:errors
							path="description" cssClass="error"></sf:errors></td> 
						</tr>
			
						<tr>
							<td class = "formlabel">Event Date:</td>
							<td><sf:input path="date" name="date" type="date"
							placeholder="YYYY-MM-DD" /><br /> <sf:errors path="date"
							cssClass="error"></sf:errors></td>	
						</tr>
			
						<tr>
							<td class = "formlabel"># of Days for the event:</td>
							<td><sf:input path="days" name="days" type="number" min="1"
							max="31" /><br /> <sf:errors path="days" cssClass="error"></sf:errors></td>	
						</tr>
			
						<tr>
							<td class = "formlabel">Create Event Code</td>
							<td><sf:input path="eventCode" name="eventCode" type="text"
							placeholder="Create An Event Code" /><br /> <sf:errors
							path="eventCode" cssClass="error"></sf:errors></td>	
						</tr>
			
					</table><br />
					
					<button class = "btn btn-primary" name="submit" id="createevent" type="submit">Create Event</button>
					</center><br />
			
				</sf:form>
			</fieldset>
			</center>
		</div>
	</div><br />
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>



