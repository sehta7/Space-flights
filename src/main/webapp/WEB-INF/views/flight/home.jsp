<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight</title>
</head>
<body>
	<table>
		<tr>
			<td><form:form method="GET" action="/space.flights/flight/add">
					<input type="submit" value="Add Flight" />
				</form:form></td>
			<td><form:form method="GET" action="/space.flights/flight/list">
					<input type="submit" value="See Flights" />
				</form:form></td>
			<td><form:form method="GET"
					action="/space.flights/flight/flights">
					<input type="submit" value="Only Flights" />
				</form:form></td>
		</tr>
	</table>
	<form:form method="GET" action="/space.flights/">
		<input type="submit" value="RETURN" />
	</form:form>
</body>
</html>