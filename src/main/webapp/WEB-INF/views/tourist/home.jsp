<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Tourist</title>
	</head>
	<body>
		<table>
            <tr>
               <td>
               	<form:form method = "GET" action = "/space.flights/tourist/add">
                  <input type = "submit" value = "Add Tourist"/>
               	</form:form>
               </td>
               <td>
               	<form:form method = "GET" action = "/space.flights/tourist/list">
                  <input type = "submit" value = "See Tourists"/>
               	</form:form>
               </td>
            </tr>
         </table>
	</body>
</html>