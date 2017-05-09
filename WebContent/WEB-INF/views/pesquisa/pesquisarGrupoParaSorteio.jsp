<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Amigo Secreto</title>
	</head>
	<body>
		<h1>Sortear ${grupo.nome}</h1>
		<form action=<c:url value="/grupo/sortear"/> method="post">
		<table>
			<thead>
				<tr>
					<th>PARTICIPANTES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${membros}">
					<tr>
						<td>${m.nome}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<input type="submit" value="Sortear Grupo">
		</form>
		<br>
		<a href=<c:url value="/home" />>Voltar</a>
	</body>
</html>