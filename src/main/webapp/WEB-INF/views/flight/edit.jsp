<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit flight</title>
</head>
<body>
	<form:form method="POST" action="/space.flights/flight/editsave">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Departure :</td>
				<td><form:input path="departure"/></td>
			</tr>
			<tr>
				<td>Arrival :</td>
				<td><form:input path="arrival"/></td>
			</tr>
			<tr>
				<td>Seats :</td>
				<td><form:input path="seatsNumber" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update flight" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>