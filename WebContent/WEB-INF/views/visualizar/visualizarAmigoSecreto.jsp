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
	<h1>Veja seu amigo secreto</h1>
	${msg}
	
	<br>
	<a href=<c:url value="/home" />>Voltar</a>

</body>
</html>