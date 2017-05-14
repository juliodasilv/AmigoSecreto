<jsp:include page="../templates/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="content-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-head-line">Criar Grupo</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Cadastre o seu grupo</div>
					<div class="panel-body">
						<form action=<c:url value="/grupo/cadastrar"/> method="post">
							<div class="col-md-12">
								<div class="form-group">
									<label for="nome">Nome do Grupo</label> <input type="text"
										class="form-control" name="nome" placeholder="Digite seu nome" />
									<sf:errors path="grupo.nome" cssStyle="color:red" />
								</div>
								<div class="form-group">
									<label for="valorMinimoPresente">Valor Mínimo do
										Presente</label> <input type="text" class="form-control" name="valorMinimoPresente"
										placeholder="Digite o valor mínimo do presente" />
									<sf:errors path="grupo.valorMinimoPresente"
										cssStyle="color:red" />
								</div>
								<div class="form-group">
									<label for="localConfraternizacao">Local da Confraternização</label> <input
										type="text" class="form-control" name="localConfraternizacao"
										placeholder="Digite a sugestão de presente" />
									<sf:errors path="grupo.localConfraternizacao" cssStyle="color:red" />
								</div>
								<div class="form-group">
									<label for="dataConfraternizacao">Data de Confraternização</label> <input
										type="date" class="form-control" name="dataConfraternizacao" />
									<sf:errors path="grupo.dataConfraternizacao" cssStyle="color:red" />
								</div>
								<div class="form-group">
									<label for="dataSorteio">Data de Sorteio</label> <input
										type="date" class="form-control" name="dataSorteio" />
									<sf:errors path="grupo.dataSorteio" cssStyle="color:red" />
								</div>

								<input type="submit" value="Cadastrar" class="btn btn-default" />
							</div>
						</form>
						${msg } <a href=<c:url value="/" />>Voltar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../templates/footer.jsp" />