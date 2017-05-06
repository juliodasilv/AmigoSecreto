<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Amigo Secreto</title>
	</head>
	<body>
		<h1>Cadastrar-se</h1>
		<form action=<c:url value="/membro/cadastrar"/> method="post">
			<table>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" size="30"></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text" name="cpf" size="30"></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="text" name="senha" size="30"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" size="30"></td>
				</tr>			
<!-- 				<tr> -->
<!-- 					<td>Data Nascimento (DD/MM/YYYY):</td> -->
<!-- 					<td><input type="text" name="dataNascimento" size="20"></td> -->
<!-- 				</tr> -->
			</table>
			<input type="submit" value="Cadastrar">
		</form>
		${msg}
		<br>
		<a href=<c:url value="/" />>Voltar</a>
	</body>
</html>