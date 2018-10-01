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
	<form:form method="post" action="../saveTourist/${idF}">
		<table>
			<tr><td>Choose tourist for ${idF}:</td></tr>
			<tr>
				<td><form:select path="tourists">
						<form:options items="${tourists}" />
					</form:select></td>
					<c:forEach var="tourist" items="tourists">
						<td><form:label path="${tourist}"></form:label></td>
					</c:forEach>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add tourist" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>