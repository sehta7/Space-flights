<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/form.css" />
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<title>Add tourist</title>
</head>
<body>
	<div class="bg-contact3">
		<div class="container-contact3">
			<div class="wrap-contact4">
				<form:form method="post" action="../saveFlight/${idT}"
					class="contact3-form validate-form">
					<table>
						<tr>
							<td>Choose flight for ${tourist.firstName}
								${tourist.lastName}:</td>
						</tr>
						<tr></tr>
						<tr>
							<td>
								<div class="wrap-input3 validate-input"
									data-validate="Must choose flight">
									<form:select path="flights" class="input3" name="flights">
										<form:options items="${flights}" />
									</form:select>
									<c:forEach var="flight" items="flights">
										<td><form:label path="${flight}"></form:label></td>
									</c:forEach>
								</div>
							</td>

						</tr>
						<tr>
							<td>
								<div class="container-contact3-form-btn">
									<input type="submit" value="Add flight"
										class="contact3-form-btn" />
								</div>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>