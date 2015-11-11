<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>ShutterShare - Login Page</title>
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
</head>

<body onload='document.f.username.focus();'>
	<!-- this is the navigation bar up top -->
	<div class="navbar navbar-default navbar-custom navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<img class="navbar-brand" src="${pageContext.request.contextPath}/resources/images/greenlogo.png" alt="shuttersharelogo">
				<button id="navbutton" class="navbar-toggle" data-toggle="collapse"
					data-target=".navHeaderCollapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/abouthome">About</a></li>
				</ul>

			</div>
		</div>
	</div>
	<br />
	<br />
	<!-- navigation bar ends-->


	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-5 centered" id="loginWelcome">
				<center>
					<h2>Welcome to</h2>
					<img src="${pageContext.request.contextPath}/resources/images/greenlogo.png" class="img-responsive"
						id="login-greenlogo" alt="greenlogo">
						
						 <br/>                        
                        <a href="https://play.google.com/store/apps/details?id=com.application.shuttershare&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-AC-global-none-all-co-pr-py-PartBadges-Oct1515-1"><img alt="Get it on Google Play" src="http://developer.android.com/images/brand/en_generic_rgb_wo_60.png" /></a>
						<br/>
				</center>

				<!-- login box (right)-->
			</div>
			<div class="col-md-5" id="userlogin">
				<h4>Login with Username and Password</h4>
				<br />
				<form name='f' action='${pageContext.request.contextPath}/login'
					method='POST'>
					<center>
						<table class="logintable">
							<tr>
								<td class="formlabel">User Email:</td>
								<td><input type='text' name='username' value=''><br /></td>
							</tr>
							<tr>
								<td class="formlabel">Password:</td>
								<td><input type='password' name='password' /></td>
							</tr>
						</table>
						<br /> <a href="${pageContext.request.contextPath}/newaccount"
							class="btn btn-line" name="submit" id="loginbutton" type="submit">Create
							New Account</a>&nbsp
						<button class="btn btn-primary" name="submit" id="loginbutton"
							type="submit">Login</button>

						<c:if test="${param.error != null}">
							<p class="loginError">Login failed - Check that your email
								and password is correct</p>
						</c:if>
					</center>
					<input name="${_csrf.parameterName}" type="hidden"
						value="${_csrf.token}" />
				</form>

			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>


</html>