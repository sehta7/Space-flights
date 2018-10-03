<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/form.css" />
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
			<div class="wrap-contact3">

				<form:form method="post" action="save"
					class="contact3-form validate-form">
					<span class="contact3-form-title"> Add tourist </span>

					<div class="wrap-input3 validate-input"
						data-validate="Name is required">
						<form:input path="firstName" class="input3" type="text"
							name="firstName" placeholder="First Name" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Last name is required">
						<form:input path="lastName" class="input3" type="text"
							name="lastName" placeholder="Last Name" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Gender is required">
						<form:select path="gender" class="input3" name="gender">
							<form:option value="-1" label="Gender"/>
							<form:options items="${gender}" />
						</form:select>
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Country is required">
						<form:input path="country" class="input3" type="text"
							name="country" placeholder="Country" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Message is required">
						<form:textarea path="notes" class="input3" name="notes"
							placeholder="Your Notes" />
						<span class="focus-input3"></span>
					</div>

					<div class="wrap-input3 validate-input"
						data-validate="Birth is required">
						<label class="input3">Birth:</label>
						<form:input path="birth" class="input3" type="date" name="birth"
							placeholder="Your Birth" />
						<span class="focus-input3"></span>
					</div>

					<div class="container-contact3-form-btn">
						<input type="submit" value="Save" class="contact3-form-btn" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>