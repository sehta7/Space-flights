<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add tourist</title>
</head>
<body>
	<form:form method="post" action="save">
		<table>
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
				<td>
					<form:select path="gender">
						<form:options items="${gender}"/>
					</form:select>
				</td>
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
				<td><form:input path="birth" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>