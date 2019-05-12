<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<c:forEach items="${categories}" var="category">
		<table>
			<tr>
				<td>Id: <c:out value="${category.id}" /></td>
			</tr>
			<tr>
				<td>Name: <c:out value="${category.name}" /> <a
					href="/spring-mvc-maven/categories/<c:out value="${category.id}" />/items">Items</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>