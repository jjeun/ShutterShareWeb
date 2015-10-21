<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" type='text/css' />
	
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>

<script type="text/javascript">

function onLoad(){
	$("#password").keyup(checkPasswordMatch);
	$("#confirmPass").keyup(checkPasswordMatch);
	
	$("#details").submit(canSubmit());
}

function canSubmit(){
	var password = $('#password').val();
	var confirmPass = $('#confirmPass').val();
	
	if(password != confirmPass){
		alert("Passwords do not match!");
		return false;
	}
		
	else{
		return true;
	}
}

function checkPasswordMatch(){
	var password = $('#password').val();
	var confirmPass = $('#confirmPass').val();
	
	if (password.length > 3 || confirmPass > 3){
	
		if(password == confirmPass){
			$("#matchPass").text("Passwords match")
			$("#matchPass").addClass("valid");
			$("#matchPass").removeClass("error");
		}
		
		else{
			$("#matchPass").text("Passwords do not match")
			$("#matchPass").addClass("error");
			$("#matchPass").removeClass("valid");
		}
	}
}

$(document).ready(onLoad);

</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShutterShare - Create New Account</title>
</head>
<body>
	Under Construction: Create Account Page



	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="users">
		<table>
			<tr>
				<td>First Name:</td>
				<td><sf:input path="firstName" name="firstName" type="text"
						placeholder="First Name" /><br /> <sf:errors path="firstName"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><sf:input path="lastName" name="lastName" type="text"
						placeholder="Last Name" /><br /> <sf:errors path="lastName"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><sf:input path="address" name="address" type="text"
						placeholder="Address" /><br /> <sf:errors path="address"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><sf:input path="city" name="city" type="text"
						placeholder="City" /><br /> <sf:errors path="city"
						cssClass="error"></sf:errors></td>
			</tr>


			<tr>
				<td>State:</td>
				<td><sf:input path="state" name="state" type="text"
						placeholder="State" /><br /> <sf:errors path="state"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>ZipCode:</td>
				<td><sf:input path="zipcode" name="zipcode" type="text"
						placeholder="ZipCode" /><br /> <sf:errors path="zipcode"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><sf:input path="userEmail" name="userEmail" type="text"
						placeholder="Email Address" /><br /> <sf:errors path="userEmail"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Telephone:</td>
				<td><sf:input path="telephone" name="telephone" type="text"
						placeholder="Telephone Number" /><br /> <sf:errors
						path="telephone" cssClass="error"></sf:errors></td>
			</tr>


			<tr>
				<td>Password:</td>
				<td><sf:input id="password" path="password" name="password" type="text"
						placeholder="Password" /><br /> <sf:errors path="password"
						cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmPass" name="confirmPass" type="text"
					placeholder="Re-Enter Password" /><div id="matchPass"></div></td>
			</tr>

			<tr>
				<td></td>
				<td><input value="Create Account" type="submit" /></td>
			</tr>

		</table>

	</sf:form>
</body>
</html>