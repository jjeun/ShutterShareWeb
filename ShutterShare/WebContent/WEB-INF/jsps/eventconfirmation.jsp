<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh"
	content="3;url=${pageContext.request.contextPath}/">

<%-- <link href="${pageContext.request.contextPath}/resources/css/" rel="stylesheet" type='text/css' media='all' /> --%>
<title>Event Confirmation</title>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />

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
					<li><a href="#">About</a></li>
					<li><a href="${pageContext.request.contextPath}/settings">Account</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">Log
							out</a></li>
				</ul>

			</div>
		</div>


	</div>
	<!-- navigation bar ends-->

	<center>
		<p>Congratulations you event has been created!</p>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>