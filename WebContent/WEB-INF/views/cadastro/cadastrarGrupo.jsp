<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Amigo Secreto</title>
	</head>
	<body>
		<h1>Criar Grupo</h1>
		<form action=<c:url value="/grupo/cadastrar"/> method="post">
			<table>
				<tr>
					<td>Nome do Grupo:</td>
					<td><input type="text" name="nome" size="30"><sf:errors path="grupo.nome"/></td>
				</tr>
				<tr>
					<td>Valor minimo do presente:</td>
					<td><input type="text" name="valorMinimoPresente" size="30"><sf:errors path="grupo.valorMinimoPresente" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Local da Confraternização:</td>
					<td><input type="text" name="localConfraternizacao" size="30"><sf:errors path="grupo.localConfraternizacao" cssStyle="color:red"/></td>
				</tr>			
				<tr>
					<td>Data Confraternização (DD/MM/YYYY):</td>
					<td><input type="date" name="dataConfraternizacao" size="20"><sf:errors path="grupo.dataConfraternizacao" cssStyle="color:red"/></td>
				</tr>
				<tr>
					<td>Data prevista para sorteio (DD/MM/YYYY):</td>
					<td><input type="date" name="dataSorteio" size="20"><sf:errors path="grupo.dataSorteio" cssStyle="color:red"/></td>
				</tr>				
			</table>
			<input type="submit" value="Cadastrar">
		</form>
		${msg}
		<br>
		<a href=<c:url value="/home" />>Voltar</a>
	</body>
</html>