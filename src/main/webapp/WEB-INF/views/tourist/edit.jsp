<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit tourist</title>
</head>
<body>
	<form:form method="POST" action="/space.flights/tourist/editsave">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:select path="gender">
						<form:options items="${gender}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td>Notes :</td>
				<td><form:input path="notes" /></td>
			</tr>
			<tr>
				<td>Birth :</td>
				<td><form:input path="birth" type="date" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update tourist" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>