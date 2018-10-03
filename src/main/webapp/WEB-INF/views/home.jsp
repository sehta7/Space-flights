<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Start Page</title>
</head>
<body>
	<div id="wrapper">
	<h1>Choose module:</h1>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<tr>
				<td class="lalign"><form:form method="GET" action="/space.flights/tourist/">
						<input type="submit" value="Manage Tourists" class="button"/>
					</form:form></td>
				<td class="lalign"><form:form method="GET" action="/space.flights/flight/">
						<input type="submit" value="Manage Flights" class="button"/>
					</form:form></td>
			</tr>
		</table>
	</div>
</body>
</html>