<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../templates/header.jsp" />

<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<script type="text/javascript">
	$(function() {
		function onTarefaItemClick() {
			$("#grupos").change(
					function() {
						$.get("listarMembros?idGrupo=" + $(this).val()).done(
								function(data) {
									console.log("entrou!!<br>" + data);
									$("#idTabela").html(data);
								})
					});
		}

		$("#grupos").click(onTarefaItemClick);
	});
</script>
<div class="content-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-head-line">Escolha um grupo para participar</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Escolha seu amigo</div>
					<div class="panel-body">
						<form action=<c:url value="/grupo/entrar"/> method="post">
							<table>
								<tr>
									<td>Selecione um Grupo:</td>
									<td><select name="idGrupo" id="grupos">
											<option value="0">[Selecione]</option>
											<c:forEach var="g" items="${grupos}">
												<c:choose>
													<c:when test="${g.id eq selected}">
														<option value="${g.id}" selected>${g.nome}</option>
													</c:when>
													<c:otherwise>
														<option value="${g.id}">${g.nome}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
								</tr>
							</table>
							<input type="submit" value="Entrar no Grupo">
						</form>
						<table>
							<thead>
								<tr>
									<th>NOME</th>
								</tr>
							</thead>
							<tbody id="idTabela">

							</tbody>
						</table>
						${msg} <br> <a href=<c:url value="/home" />>Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<h1>Escolha um grupo que gostaria de participar</h1>


<jsp:include page="../templates/footer.jsp" />