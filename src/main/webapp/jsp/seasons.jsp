<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seasons</title>
</head>
<body>
	<c:forEach items="${seasons}" var="season">
		<table>
			<tr>
				<td>Id: <c:out value="${season.id}" /></td>
			</tr>
			<tr>
				<td>Name: <c:out value="${season.name}" /> <a
					href="seasons/<c:out value="${season.id}" />">Details</a></td>
			</tr>
			<tr>
				<td><a href="seasons/<c:out value="${season.id}" />/wears">Wears</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>