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
		<h1>Login</h1>
		<div class="login-page">
			<div class="form">
				<form class="login-form" action=<c:url value="/logar"/> method="post">
					<table>
						<tr>
							<td>EMAIL:</td>
							<td><input type="text" name="email" size="30"></td>
						</tr>
						<tr>
							<td>SENHA:</td>
							<td><input type="password" name="senha" size="30"></td>
						</tr>
					</table>
					<input type="submit" value="ENTRAR"><br/>
					<a href=<c:url value="/membro/iniciarCadastro" />>CADASTRE-SE AQUI</a>
				</form>
				${msg}
			</div>
		</div>
	</body>
</html>