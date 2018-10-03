<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>List of tourists</title>
</head>
<body>
	<div id="wrapper">
		<form:form method="GET" action="/space.flights/tourist/">
			<input type="submit" value="RETURN" class="button" />
		</form:form>
		<br>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>First Name</span></th>
					<th><span>Last Name</span></th>
					<th><span>Gender</span></th>
					<th><span>Country</span></th>
					<th><span>Notes</span></th>
					<th><span>Birth</span></th>
					<th><span> </span></th>
					<th><span> </span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tourist" items="${touristsList}">
					<tr>
						<td class="lalign">${tourist.firstName}</td>
						<td class="lalign">${tourist.lastName}</td>
						<td class="lalign">${tourist.gender}</td>
						<td class="lalign">${tourist.country}</td>
						<td class="lalign">${tourist.notes}</td>
						<td class="lalign">${tourist.birth}</td>
						<td><a href="edit/${tourist.id}" class="link">Edit</a></td>
						<td><a href="delete/${tourist.id}" class="link">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<form:form method="GET" action="/space.flights/tourist/add">
				<input type="submit" value="Add Tourist" class="button" />
			</form:form>
		</p>
	</div>
</body>
</html>