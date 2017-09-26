<%@ include file="../head.jsp" %>

<div id="titulo_pg">Formulário - Grade curricular</div>

<s:form namespace="/cursoDisciplinaStruts" action="listarGradeAction" method="post">
	<s:textfield label="Nome" name="nomeCurso" />	
	<s:submit value="Salvar" />
</s:form>

<%@ include file="../rodape.jsp" %>