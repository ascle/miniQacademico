<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formul�rio - Incluir curso na disciplina</div>

<s:form namespace="cursoDisciplinaStruts" action="incluirCursoDisciplinaAction" method="post">
	<s:textfield label="Codigo da disciplina" name="codDisciplina" />
	<s:textfield label="C�digo do curso" name="codCurso" />
	<s:textfield label="N�mero do periodo" name="numPeriodo" />
	<s:textfield label="Tipo de disciplina" name="tipoDisciplina" />
	<s:submit value="Inserir" />
</s:form>

<%@ include file="../rodape.jsp" %>