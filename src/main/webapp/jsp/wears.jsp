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
	<c:forEach items="${wears}" var="wear">
		<table>
			<tr>
				<td>Id: <c:out value="${wear.id}" /></td>
			</tr>
			<tr>
				<td>Name: <c:out value="${wear.name}" /> <a
					href="/spring-mvc-maven/wears/<c:out value="${wear.id}" />/categories">categories</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>