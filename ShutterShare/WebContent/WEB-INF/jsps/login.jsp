<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ShutterShare - Login Page</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" type='text/css' />
</head>
<body onload='document.f.username.focus();'>
	<h1>Welcome to ShutterShare</h1>
	<h3>Login with Username and Password</h3>
	
	<c:if test="${param.error != null}">
		<p class="loginError">Login failed - Check that your email and password is correct</p>
	
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td>User Email:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
		<input name="${_csrf.parameterName}" type="hidden"
				value="${_csrf.token}" />
	</form>
	
	<p><a href="${pageContext.request.contextPath}/newaccount">Create New Account</a></p>
</body>
</html>