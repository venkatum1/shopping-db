<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Details</title>
</head>
<body>
	<table>
		<tr>
			<td>Id: ${item.id}</td>
		</tr>
		<tr>
			<td>Name: ${item.name}</td>
		</tr>
		<tr>
			<td>Price: ${item.price}</td>
		</tr>
		<tr>
			<td>Size: ${item.size}</td>
		</tr>
	</table>
</body>
</html>