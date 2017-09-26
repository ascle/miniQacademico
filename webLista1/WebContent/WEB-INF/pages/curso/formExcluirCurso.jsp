<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formulário - Excluir Curso</div>

<s:form namespace="cursoStruts" action="excluirCursoAction" method="post">
	<s:textfield label="Código" name="codCurso" />	
	<s:submit value="Salvar" />
</s:form>

<%@ include file="../rodape.jsp" %>