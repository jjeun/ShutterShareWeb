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
<title>ShutterShare - Create New Account</title>
</head>
<body>
	Under Construction: Create Account Page



	<sf:form method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="users">
		<table>
			<tr>
				<td>First Name:</td>
				<td><sf:input path="firstName" name="firstName" type="text"
						placeholder="First Name" /> <sf:errors path="firstName"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><sf:input path="lastName" name="lastName" type="text"
						placeholder="Last Name" /> <sf:errors path="lastName"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><sf:input path="address" name="address" type="text"
						placeholder="Address" /> <sf:errors path="address"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><sf:input path="city" name="city" type="text"
						placeholder="City" /> <sf:errors path="city" cssClass="error"></sf:errors></td>
			</tr>


			<tr>
				<td>State:</td>
				<td><sf:input path="state" name="state" type="text"
						placeholder="State" /> <sf:errors path="state" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>ZipCode:</td>
				<td><sf:input path="zipcode" name="zipcode" type="text"
						placeholder="ZipCode" /> <sf:errors path="zipcode"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><sf:input path="email" name="email" type="text"
						placeholder="Email Address" /> <sf:errors path="email"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Telephone:</td>
				<td><sf:input path="telephone" name="telephone" type="text"
						placeholder="Telephone Number" /> <sf:errors path="telephone"
						cssClass="error"></sf:errors></td>
			</tr>


			<tr>
				<td>Password:</td>
				<td><sf:input path="password" name="password" type="text"
						placeholder="Password" /> <sf:errors path="password"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Confirm Password:</td>
				<td><input name="confirmPass" type="text"
					placeholder="Re-Enter Password" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input value="Create Account" type="submit" /></td>
			</tr>

		</table>

	</sf:form>
</body>
</html>