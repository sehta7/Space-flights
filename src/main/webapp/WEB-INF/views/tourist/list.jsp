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
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Country</th>
			<th>Notes</th>
			<th>Birth</th>
		</tr>
		<c:forEach var="tourist" items="${touristsList}">
			<tr>
					<td>${tourist.firstName}</td>
					<td>${tourist.lastName}</td>
					<td>${tourist.gender}</td>
					<td>${tourist.country}</td>
					<td>${tourist.notes}</td>
					<td>${tourist.birth}</td>
				</tr>
				<tr>
					<td>Flights:</td>
					<td>Departure</td>
					<td>Arrival</td>
					<td>Price</td>
					<td><a href="addFlight/${tourist.id}">Add Flight</a></td>
				</tr>
			<tr>
				<c:forEach var="flight" items="${tourist.flights}">
					<tr>
						<td></td>
						<td>${flight.departure}</td>
						<td>${flight.arrival}</td>
						<td>${flight.price}</td>
						<td><a href="deleteFlight/${tourist.id}/${flight.id}">Delete</a></td>
					</tr>
				</c:forEach>
		
	</c:forEach>
		</table>
</body>
</html>