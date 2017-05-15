<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
	<form:form method="GET" action="/sdnext/search_res.html">
		<h2>Search Patient Database</h2>
	<table>
		<tr><td align="center"><h3>Search Patient ID</h3></td></tr>
		<tr><td ><b>Patient ID</b></td>
        <td align="left">: <input  type="text" name="patientid" id="patientid">
        </td></tr>
        <tr><td colspan=2 align="center">
        <input  type="submit" name="submit" value="Search"></td></tr>
    </table>
	</form:form>
	
	 <c:if test="${!empty patients}">
	<table align="left" border="1">
		<tr>
			<th>Patient ID</th>
			<th>Patient Name</th>
			<th>Patient Age</th>
			<th>Patient Disease</th>
			<th>Patient Address</th>
		</tr>
			<tr>
				<td><c:out value="${patients.id}"/></td>
				<td><c:out value="${patients.name}"/></td>
				<td><c:out value="${patients.age}"/></td>
				<td><c:out value="${patients.disease}"/></td>
				<td><c:out value="${patients.address}"/></td>
			</tr>
	</table>
</c:if>
	</body>

</html>