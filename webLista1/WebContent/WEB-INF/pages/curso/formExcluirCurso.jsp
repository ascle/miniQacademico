<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formul�rio - Excluir Curso</div>

<s:form namespace="cursoStruts" action="excluirCursoAction" method="post">
	<s:textfield label="C�digo" name="codCurso" />	
	<s:submit value="Salvar" />
</s:form>

<%@ include file="../rodape.jsp" %>