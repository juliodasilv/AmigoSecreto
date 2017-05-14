<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- BOOTSTRAP CORE STYLE  -->
	    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" />
	    <!-- FONT AWESOME ICONS  -->
	    <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet" />
	    <!-- CUSTOM STYLE  -->
	    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" />
		<title>Amigo Secreto - Login</title>
	</head>
	<body>
	
		<header>
	        <div class="container">
	            <div class="row">
	                <div class="col-md-12">
	                    <strong>Helena: </strong>RM31321
	                    &nbsp;&nbsp;
	                    <strong>Julio: </strong>RM31524
	                </div>
	
	            </div>
	        </div>
	    </header>
	    
	    <!-- HEADER END-->
	    <div class="navbar navbar-inverse set-radius-zero">
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href="index.html">
	
	                    <img src="<c:url value="/resources/img/logo.png"/>" />
	                </a>
	
	            </div>
	
	            <div class="left-div">
	                <i class="fa fa-user-plus login-icon" ></i>
				</div>
	        </div>
	    </div>
	    <!-- LOGO HEADER END-->
	
		<!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">Por favor, faça login </h4>

                </div>

            </div>
            <div class="row">
                <div class="col-md-6">
                   <h4> Cadastre-se <strong> / </strong></h4>
                    <br />
                    
					<a class="btn btn-info" href=<c:url value="/membro/iniciarCadastro" />>CADASTRE-SE AQUI</a>
					
                    <hr />
                     <h4> Ou faça <strong>Login:</strong></h4>
                    <br />
					<form action=<c:url value="/logar"/> method="post">
                     <label>E-mail : </label>
                        <input type="text" class="form-control" name="email" />
                        <label>Senha:  </label>
                        <input type="password" class="form-control" name="senha" />
                        <hr />
						<input type="submit" value="Login" class="btn btn-info"><br/>
                        
					</form>
					${msg}
                </div>
                
            </div>
        </div>
    </div>

<jsp:include page="./templates/footer.jsp" />