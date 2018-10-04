<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>List of tourist</title>
</head>
<body>
	<div id="wrapper">
		<form:form method="GET" action="/space.flights/tourist/">
			<input type="submit" value="RETURN" class="button" />
		</form:form>
		<br>
		<h1>Full list</h1>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>First Name</span></th>
					<th><span>Last Name</span></th>
					<th><span>Gender</span></th>
					<th><span>Country</span></th>
					<th><span>Notes</span></th>
					<th><span>Birth</span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tourist" items="${touristsList}">
					<tr>
						<td class="tourist">${tourist.firstName}</td>
						<td class="tourist">${tourist.lastName}</td>
						<td class="tourist">${tourist.gender}</td>
						<td class="tourist">${tourist.country}</td>
						<td class="tourist">${tourist.notes}</td>
						<td class="tourist">${tourist.birth}</td>
					</tr>
					<tr class="under">
						<td class="lalign">Flights:</td>
						<td class="lalign">Departure</td>
						<td class="lalign">Arrival</td>
						<td class="lalign">Price</td>
						<td><a href="addFlight/${tourist.id}" class="link">Add Flight</a></td>
					</tr>
					<tr>
						<c:forEach var="flight" items="${tourist.flights}">
							<tr>
								<td ></td>
								<td class="lalign">${flight.departure}</td>
								<td class="lalign">${flight.arrival}</td>
								<td class="lalign">${flight.price}</td>
								<td><a href="deleteFlight/${tourist.id}/${flight.id}" class="link">Delete</a></td>
							</tr>
						</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>