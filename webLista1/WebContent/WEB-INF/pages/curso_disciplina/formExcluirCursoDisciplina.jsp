<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formul�rio - Remover curso da disciplina</div>

<s:form namespace="cursoDisciplinaStruts" action="excluirCursoDisciplinaAction" method="post">
	<s:textfield label="Codigo da disciplina" name="codDisciplina" />
	<s:textfield label="C�digo do curso" name="codCurso" />
	<s:submit value="Remover" />
</s:form>

<%@ include file="../rodape.jsp" %>