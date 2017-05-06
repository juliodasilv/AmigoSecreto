<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Escolas</title>
</head>
<body>

	<form action=<c:url value="/listarcursos"/> method="post">
		<table>
			<tr>
				<td>Selecione a escola:</td>
				<td><select name="idc">
						<c:forEach var="e" items="${escolas}">
							<c:choose>
								<c:when test="${e.id eq selected}">
									<option value="${e.id}" selected>${e.descricao}</option>
								</c:when>
								<c:otherwise>
									<option value="${e.id}">${e.descricao}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Listar Cursos">
	</form>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>DESCRIÇÃO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${cursos}">
				<tr>
					<td>${c.id}</td>
					<td>${c.descricao}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	<a href=<c:url value="/" />>Voltar</a>

</body>
</html>