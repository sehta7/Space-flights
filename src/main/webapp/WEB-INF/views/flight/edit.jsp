<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/form.css" />
<link rel="stylesheet" type="text/css" href="../../css/style.css" />
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
<title>Edit flight</title>
</head>
<body>
	<div class="bg-contact3">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<form:form method="POST" action="/space.flights/flight/editsave"
					class="contact3-form validate-form">
					<span class="contact3-form-title"> Edit flight </span>
					
					<div class="wrap-input3 validate-input">
						<form:hidden path="id" />
					</div>
					
					<div class="wrap-input3 validate-input"
						data-validate="Date format: YYYY-mm-dd HH:mm:ss">
						<form:input path="departure" class="input3" type="text"
							name="departure" placeholder="Departure" />
						<span class="focus-input3"></span>
					</div>
					
					<div class="wrap-input3 validate-input"
						data-validate="Date format: YYYY-mm-dd HH:mm:ss">
						<form:input path="arrival" class="input3" type="text"
							name="arrival" placeholder="Arrival" />
						<span class="focus-input3"></span>
					</div>
					
					<div class="wrap-input3 validate-input"
						data-validate="Seats number is required">
						<form:input path="seatsNumber" class="input3" type="number"
							name="seats" placeholder="Seats number" />
						<span class="focus-input3"></span>
					</div>
					
					<div class="wrap-input3 validate-input"
						data-validate="Price is required">
						<form:input path="price" class="input3" type="number" step="0.01"
							name="price" placeholder="Price" />
						<span class="focus-input3"></span>
					</div>
					
					<div class="container-contact3-form-btn">
						<input type="submit" value="Update flight" class="contact3-form-btn" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>