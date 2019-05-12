<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>
</head>
<body>
	<c:forEach items="${items}" var="item">
		<table>
			<tr>
				<td>Id: <c:out value="${item.id}" /></td>
			</tr>
			<tr>
				<td>Name: <c:out value="${item.name}" />
				</td>
			</tr>
			<tr>
				<td><a href="/spring-mvc-maven/items/<c:out value="${item.id}" />">Details</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>