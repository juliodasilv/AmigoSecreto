<jsp:include page="../templates/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="content-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-head-line">Sortear Grupo</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Sortear Grupo: ${grupo.nome}</div>
					<div class="panel-body">

						<form action=<c:url value="/grupo/sortear"/> method="post">
							<table>
								<thead>
									<tr>
										<th>PARTICIPANTES</th>
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
							<input type="submit" value="Sortear Grupo">
						</form>
						${msg} <br> <a href=<c:url value="/home" />>Voltar</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />