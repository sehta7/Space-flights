<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Start Page</title>
	</head>
	<body>
		<table>
		<tr>
			<td><form:form method="GET" action="/space.flights/tourist/">
					<input type="submit" value="Manage Tourists" />
				</form:form></td>
			<td><form:form method="GET" action="/space.flights/flight/">
					<input type="submit" value="Manage Flights" />
				</form:form></td>
		</tr>
	</table>
	</body>
</html>