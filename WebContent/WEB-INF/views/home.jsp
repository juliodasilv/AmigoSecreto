<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Opções</title>
</head>
<body>
	<h1>Menu de Opções</h1>
	<ul>
		<li><a href=<c:url value="/grupo/iniciarCadastro" />>Criar Grupo</a></li>
		<li><a href=<c:url value="/grupo/pesquisar" />>Entrar em um grupo existente</a></li>
		<li><a href=<c:url value="/grupo/iniciarSorteio" />>Sortear</a></li>
		<li><a href=<c:url value="/membro/visualizarAmigoSecreto" />>Visualizar Amigo Secreto</a></li>
		<li><a href=<c:url value="/logooff" />>Sair</a></li>
	</ul>
	${msg}
</body>
</html>