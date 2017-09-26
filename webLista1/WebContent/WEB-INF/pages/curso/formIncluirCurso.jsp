<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formulário - Incluir Curso</div>

<s:form namespace="cursoStruts" action="incluirCursoAction" method="post">
	<s:textfield label="Nome" name="nomeCurso" />	
	<s:submit value="Salvar" />
</s:form>


<%@ include file="../rodape.jsp" %>