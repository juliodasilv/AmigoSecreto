<jsp:include page="../templates/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="content-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-head-line">Visualizar Amigo Secreto</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Veja seu amigo secreto</div>
					<div class="panel-body">
						${msg } 
						
						<br>
						
						<a href=<c:url value="/" />>Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />
