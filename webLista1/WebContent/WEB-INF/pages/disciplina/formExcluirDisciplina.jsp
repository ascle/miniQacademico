<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formul�rio - Excluir disciplina</div>

<s:form namespace="disciplinaStruts" action="excluirDisciplinaAction" method="post">
	<s:textfield label="Codigo da disciplina" name="codDisciplina" />
	<s:submit value="Remover" />
</s:form>

<%@ include file="../rodape.jsp" %>