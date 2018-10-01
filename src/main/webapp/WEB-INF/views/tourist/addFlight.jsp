<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add tourist</title>
</head>
<body>
	<form:form method="post" action="../saveFlight/${idT}">
		<table>
			<tr><td>Choose flight for ${idT}:</td></tr>
			<tr>
				<td><form:select path="flights">
						<form:options items="${flights}" />
					</form:select></td>
					<c:forEach var="flight" items="flights">
						<td><form:label path="${flight}"></form:label></td>
					</c:forEach>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add flight" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>