<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	<title>ShutterShare - Account Settings</title>
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
					<li><a href = "${pageContext.request.contextPath}/">Home</a></li>
					<li><a href = "${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/settings">Account</a></li>
					<li><a href= "${pageContext.request.contextPath}/logout">Log out</a></li>
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
				<sf:form id="details" method="post" action="${pageContext.request.contextPath}/updateaccount" commandName="users">
					<center>
					<h4>Update Account</h4><br />
					<table>
						<tr>
							<td class = "formlabel">First Name:</td>
							<td><sf:input path="firstName" name="firstName" type="text"
						 		value="${user.firstName}"/><br /> <sf:errors path="firstName"
								cssClass="error"></sf:errors></td>
						</tr>
			
						<tr>
							<td class = "formlabel">Last Name:</td>
							<td><sf:input path="lastName" name="lastName" type="text"
								value="${user.lastName}" /><br /> <sf:errors path="lastName"
								cssClass="error"></sf:errors></td>
						</tr>
			
						<tr>
							<td class = "formlabel">Address:</td>
							<td><sf:input path="address" name="address" type="text"
									value="${user.address}" /><br /> <sf:errors path="address"
									cssClass="error"></sf:errors></td>
						</tr>
			
						<tr>
							<td class = "formlabel">City:</td>
							<td><sf:input path="city" name="city" type="text"
									value="${user.city}" /><br /> <sf:errors path="city"
									cssClass="error"></sf:errors></td>
						</tr>
			
			
						<tr>
							<td class = "formlabel">State:</td>
							<td>
								<sf:select name="state" class="form-control" path="state">
									<option selected="selected">${user.state}</option>
									<option value="AL">AL</option>
									<option value="AK">AK</option>
									<option value="AZ">AZ</option>
									<option value="AR">AR</option>
									<option value="CA">CA</option>
									<option value="CO">CO</option>
									<option value="CT">CT</option>
									<option value="DE">DE</option>
									<option value="DC">DC</option>
									<option value="FL">FL</option>
									<option value="GA">GA</option>
									<option value="HI">HI</option>
									<option value="ID">ID</option>
									<option value="IL">IL</option>
									<option value="IN">IN</option>
									<option value="IA">IA</option>
									<option value="KS">KS</option>
									<option value="KY">KY</option>
									<option value="LA">LA</option>
									<option value="ME">ME</option>
									<option value="MD">MD</option>
									<option value="MA">MA</option>
									<option value="MI">MI</option>
									<option value="MN">MN</option>
									<option value="MS">MS</option>
									<option value="MO">MO</option>
									<option value="MT">MT</option>
									<option value="NE">NE</option>
									<option value="NV">NV</option>
									<option value="NH">NH</option>
									<option value="NJ">NJ</option>
									<option value="NM">NM</option>
									<option value="NY">NY</option>
									<option value="NC">NC</option>
									<option value="ND">ND</option>
									<option value="OH">OH</option>
									<option value="OK">OK</option>
									<option value="OR">OR</option>
									<option value="PA">PA</option>
									<option value="RI">RI</option>
									<option value="SC">SC</option>
									<option value="SD">SD</option>
									<option value="TN">TN</option>
									<option value="TX">TX</option>
									<option value="UT">UT</option>
									<option value="VT">VT</option>
									<option value="VA">VA</option>
									<option value="WA">WA</option>
									<option value="WV">WV</option>
									<option value="WI">WI</option>
									<option value="WY">WY</option>
								</sf:select><sf:errors path="state"
									cssClass="error"></sf:errors>
							</td>
						</tr>
						
						
						<tr>
							<td class = "formlabel">ZipCode:</td>
							<td><sf:input path="zipcode" name="zipcode" type="text"
									value="${user.zipcode}" /><br /> <sf:errors path="zipcode"
									cssClass="error"></sf:errors></td>
						</tr>

			
						<tr>
							<td class = "formlabel">Telephone:</td>
							<td><sf:input path="telephone" name="telephone" type="text"
									value="${user.telephone}" /><br /> <sf:errors
									path="telephone" cssClass="error"></sf:errors></td>
						</tr>
			
			
						<tr>
							<td class="formlabel">Password:</td>
							<td><sf:input id="password" path="password" name="password"
									type="text" value="${user.password}" /><br /> <sf:errors
									path="password" cssClass="error"></sf:errors></td>
						</tr>
			
						<tr>
							<td>Confirm Password:</td>
							<td><input id="confirmPass" name="confirmPass" type="text"
								value="${user.password}" />
							<div id="matchPass"></div></td>
						</tr>
			
					</table><br />
					
					<sf:input path="userEmail" name="userEmail" type="hidden"
						value="${user.userEmail}" />
					
					<button class = "btn btn-primary" name="submit" id="createaccount" type="submit">Update Account</button>
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
