<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- BOOTSTRAP CORE STYLE  -->
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" />


<title>Amigo Secreto - Login</title>
</head>
<body>

	<header>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<strong>Helena: </strong>RM31321 &nbsp;&nbsp; <strong>Julio:
					</strong>RM31524
				</div>

			</div>
		</div>
	</header>

	<!-- HEADER END-->
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"> <img
					src="<c:url value="/resources/img/logo.png"/>" />
				</a>

			</div>

			<div class="left-div">
				<i class="fa fa-user-plus login-icon"></i>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->

	<section class="menu-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a href=<c:url value="/grupo/iniciarCadastro" />>Criar
									Grupo</a></li>
							<li><a href=<c:url value="/grupo/pesquisar" />>Entrar em
									um grupo existente</a></li>
							<li><a href=<c:url value="/membro/visualizarAmigoSecreto" />>Visualizar
									Amigo Secreto</a></li>
							<li><a href=<c:url value="/grupo/iniciarSorteio" />>Sortear
									Amigo Secreto</a></li>
							<li><a href=<c:url value="/logooff" />>Sair</a></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>