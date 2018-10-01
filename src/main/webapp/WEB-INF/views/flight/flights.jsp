<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of tourist</title>
</head>
<body>
	<form:form method="GET" action="/space.flights/tourist/">
		<input type="submit" value="RETURN" />
	</form:form>
	<br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Departure</th>
			<th>Arrival</th>
			<th>Seats</th>
			<th>Price</th>
		</tr>
		<c:forEach var="flight" items="${flightsList}">
			<tr>
				<td>${flight.departure}</td>
				<td>${flight.arrival}</td>
				<td>${flight.seatsNumber}</td>
				<td>${flight.price}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<form:form method="GET" action="/space.flights/flight/add">
			<input type="submit" value="Add Tourist" />
		</form:form>
	</p>
</body>
</html>