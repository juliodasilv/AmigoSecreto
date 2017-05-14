<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
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
<title>Amigo Secreto - Cadastro</title>
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

	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-head-line">Cadastre-se</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">Faça seu Cadastro</div>
						<div class="panel-body">
							<form action=<c:url value="/membro/cadastrar"/> method="post">
								<div class="col-md-6">
									<div class="form-group">
										<label for="nome">Nome</label> <input type="text"
											class="form-control" name="nome"
											placeholder="Digite seu nome" />
										<sf:errors path="membro.nome" cssStyle="color:red" />
									</div>
									<div class="form-group">
										<label for="cpf">CPF</label> <input type="text"
											class="form-control" name="cpf" placeholder="Digite seu cpf" />
										<sf:errors path="membro.cpf" cssStyle="color:red" />
									</div>
									<div class="form-group">
										<label for="dataNascimento">Data de Nascimento</label> <input
											type="date" class="form-control" name="dataNascimento" />
										<sf:errors path="membro.dataNascimento" cssStyle="color:red" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="email">Email address</label> <input type="email"
											class="form-control" name="email"
											placeholder="Digite seu e-mail" />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control" name="senha"
											placeholder="Password" />
									</div>
									<div class="form-group">
										<label for="detalhePresente">Sugestões de Presente</label> <input
											type="text" class="form-control" name="detalhePresente"
											placeholder="Digite a sugestão de presente" />
										<sf:errors path="membro.detalhePresente" cssStyle="color:red" />
									</div>

								</div>

								<input type="submit" value="Cadastrar" class="btn btn-default" />

							</form>
							${msg } <a href=<c:url value="/" />>Voltar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../templates/footer.jsp" />