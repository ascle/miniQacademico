<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formul�rio - Alterar disciplina</div>

<s:form namespace="disciplinaStruts" action="alterarDisciplinaAction" method="post">
	<s:textfield label="Codigo" name="codDisciplina" />
	<s:textfield label="Nome" name="nomeDisciplina" />
	<s:textfield label="Cr�ditos" name="numCreditosDisc" />
	<s:textfield label="Pr�-requisito 1" name="preReqDisciplina_1" />
	<s:textfield label="Pr�-requisito 2" name="preReqDisciplina_2" />
	<s:submit value="Salvar" />
</s:form>

<%@ include file="../rodape.jsp" %>