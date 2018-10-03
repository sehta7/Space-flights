<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>Tourist</title>
</head>
<body>
	<div id="wrapper">
	<h1>Available options:</h1>
		<table id="keywords" cellspacing="0" cellpadding="0">
			<tr>
				<td class="lalign"><form:form method="GET" action="/space.flights/tourist/add">
						<input type="submit" value="Add Tourist" class="button"/>
					</form:form></td>
				<td class="lalign"><form:form method="GET"
						action="/space.flights/tourist/list">
						<input type="submit" value="See Tourists" class="button"/>
					</form:form></td>
				<td class="lalign"><form:form method="GET"
						action="/space.flights/tourist/tourists">
						<input type="submit" value="Only Tourists" class="button"/>
					</form:form></td>
			</tr>
		</table>
		<form:form method="GET" action="/space.flights/">
			<input type="submit" value="RETURN" class="button"/>
		</form:form>
	</div>
</body>
</html>