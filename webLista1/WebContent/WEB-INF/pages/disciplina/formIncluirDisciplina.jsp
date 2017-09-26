<%@ include file="../head.jsp" %>

<div id="titulo_pg">Incluir Disciplina</div>

<s:form action="incluirDisciplinaAction" method="post">
	<s:textfield label="Codigo" name="codDisciplina" />
	<s:textfield label="Nome" name="nomeDisciplina" />
	<s:textfield label="Créditos" name="numCreditosDisc" />
	<s:textfield label="Pré-requisito 1" name="preReqDisciplina_1" />
	<s:textfield label="Pré-requisito 2" name="preReqDisciplina_2" />
	<s:submit value="Salvar" />
</s:form>
<!-- 
<s:form namespace="disciplinaStruts" action="incluirDisciplinaAction" method="post" value="disciplina">
	<s:textfield label="Codigo" name="codDisciplina" />
	<s:textfield label="Nome" name="nomeDisciplina" />
	<s:textfield label="Créditos" name="numCreditosDisc" />
	<s:textfield label="Pré-requisito 1" name="preReqDisciplina_1" />
	<s:textfield label="Pré-requisito 2" name="preReqDisciplina_2" />
	<s:submit value="Salvar" />
</s:form>
 -->

<%@ include file="../rodape.jsp" %>