<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type='text/css'/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Under Construction: Create Events Page



	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="events">
		<table>
			<tr>
				<td>Event Name:</td>
				<td><sf:input path="description" name="description" type="text" placeholer="Create An Event Name"/>
					<sf:errors path="description" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Event Date:</td>
				<td><sf:input path="date" name="date" type="date" placeholder="YYYY-MM-DD"/>
					<sf:errors path="date" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Number of Days for the event:</td>
				<td><sf:input path="days" name="days" type="number" min="1"
						max="31" />
					<sf:errors path="days" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td>Create Event Code (Between 6-12 characters):</td>
				<td><sf:input path="code" name="code" type="text" placeholder="Create An Event Code"/> <sf:errors
						path="code" cssClass="error"></sf:errors></td>
			</tr>

			<tr>
				<td></td>
				<td><input value="Create Event" type="submit" /></td>
			</tr>

		</table>

	</sf:form>
</body>
</html>