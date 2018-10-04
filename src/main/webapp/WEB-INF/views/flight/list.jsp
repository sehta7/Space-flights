<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>List of flights</title>
</head>
<body>
	<div id="wrapper">
		<form:form method="GET" action="/space.flights/flight/">
			<input type="submit" value="RETURN" class="button" />
		</form:form>
		<h1>Full list</h1>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>Departure</span></th>
					<th><span>Arrival</span></th>
					<th><span>Seats</span></th>
					<th><span>Price</span></th>
					<th><span> </span></th>
					<th><span> </span></th>
					<th><span> </span></th>
					<th><span> </span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="flight" items="${flightsList}">
					<tr>
						<td class="flight">${flight.departure}</td>
						<td class="flight">${flight.arrival}</td>
						<td class="flight">${flight.seatsNumber}</td>
						<td class="flight">${flight.price}</td>
						<td class="flight" />
						<td class="flight" />
						<td class="flight" />
						<td class="flight" />
					</tr>
					<tr class="under">
						<td></td>
						<td class="lalign">First Name:</td>
						<td class="lalign">Last Name:</td>
						<td class="lalign">Gender:</td>
						<td class="lalign">Country:</td>
						<td class="lalign">Notes:</td>
						<td class="lalign">Birth:</td>
						<td><a href="addTourist/${flight.id}" class="link">Add
								Tourist</a></td>
					</tr>
					<tr>
						<c:forEach var="tourist" items="${flight.tourists}">
							<tr>
								<td></td>
								<td class="lalign">${tourist.firstName}</td>
								<td class="lalign">${tourist.lastName}</td>
								<td class="lalign">${tourist.gender}</td>
								<td class="lalign">${tourist.country}</td>
								<td class="lalign">${tourist.notes}</td>
								<td class="lalign">${tourist.birth}</td>
								<td><a href="deleteTourist/${tourist.id}/${flight.id}"
									class="link">Delete</a></td>
							</tr>
						</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>