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
		<br>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>Departure</span></th>
					<th><span>Arrival</span></th>
					<th><span>Seats</span></th>
					<th><span>Price</span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="flight" items="${flightsList}">
					<tr>
						<td class="lalign">${flight.departure}</td>
						<td class="lalign">${flight.arrival}</td>
						<td class="lalign">${flight.seatsNumber}</td>
						<td class="lalign">${flight.price}</td>
						<td><a href="edit/${flight.id}" class="link">Edit</a></td>
						<td><a href="delete/${flight.id}" class="link">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<form:form method="GET" action="/space.flights/flight/add">
				<input type="submit" value="Add Flight" class="button" />
			</form:form>
		</p>
	</div>
</body>
</html>