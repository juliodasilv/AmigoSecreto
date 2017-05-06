<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Amigo Secreto</title>
	</head>
	<body>
		<h1>Escolha um grupo que gostaria de participar</h1>
		<form action=<c:url value="/grupo/entrar"/> method="post">
			<table>
				<tr>
					<td>Selecione a Grupo:</td>
					<td><select name="idGrupo" onchange=<c:url value="/grupo/listarMembros"/>>
							<option value="">[Selecione]</option>
							<c:forEach var="g" items="${grupos}">
								<c:choose>
									<c:when test="${g.id eq selected}">
										<option value="${g.id}" selected>${g.nome}</option>
									</c:when>
									<c:otherwise>
										<option value="${g.id}">${g.nome}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="Entrar no Grupo">
		</form>
		<table>
			<thead>
				<tr>
					<th>NOME</th>
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
		<br>
		<a href=<c:url value="/home" />>Voltar</a>
	</body>
</html>