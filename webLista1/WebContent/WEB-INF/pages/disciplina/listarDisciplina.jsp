<%@ include file="../head.jsp" %>

<div id="titulo_pg">Lista de Disciplinas</div>
	
	<br />
	<table border="1"> 
		<tr style="font-size:15px; "> 
			<td>Codigo</td>   	  
        	<td>Nome</td>
        	<td>Créditos</td> 
        	<td>Pre-requisito 1</td>
        	<td>Pre-requisito 2</td>
        </tr>
        <%int count = 0;%>
    	<s:iterator value="listaDisc" id="nomeDisciplina">      		    	
        <% if( count%2 == 0 ) {%>      		    	
        	<tr style="background-color:grey">
        <%}else{ %>
        	<tr>
        <%} %>        		     
        		<td>
        			<s:property value="codDisciplina" />
        		</td>   	  
           		<td>           
           			<s:property value="nomeDisciplina" />           			
           		</td>
           		<td>
          			<s:property value="numCreditosDisc" />
          		</td>
           		<td>	
           			<s:property value="preReqDisciplina_1" />
          		</td>
          		<td>	
           			<s:property value="preReqDisciplina_2" />
          		</td>
          		<td>	
          			<s:form namespace="disciplinaStruts" action="excluirDisciplinaAction" method="post">
          				<s:hidden name="codDisciplina" value="%{codDisciplina}" />
          				<s:hidden name="nomeDisciplina" value="%{nomeDisciplina}" />
          				<s:hidden name="numCreditosDisc" value="%{numCreditosDisc}" />
          				<s:hidden name="preReqDisciplina_1" value="%{preReqDisciplina_1}" />
          				<s:hidden name="preReqDisciplina_2" value="%{preReqDisciplina_2}" />
          				<s:hidden name="origem" value="listar" />
           				<s:submit value="Remover" />
           			</s:form>	
           		</td>
           		<td>	
           			<s:form namespace="disciplinaStruts" action="alterarDisciplinaAction!input" method="post">
           				<s:hidden name="codDisciplina" value="%{codDisciplina}" />
           				<s:hidden name="nomeDisciplina" value="%{nomeDisciplina}" />
          				<s:hidden name="numCreditosDisc" value="%{numCreditosDisc}" />
          				<s:hidden name="preReqDisciplina_1" value="%{preReqDisciplina_1}" />
          				<s:hidden name="preReqDisciplina_2" value="%{preReqDisciplina_2}" />
           				<s:hidden name="origem" value="listar" />
           				<s:submit value="Alterar" />
           			</s:form>
          		</td>          			                                   
        	</tr>  
        	<% count++; %>              		        
    	</s:iterator>
    </table>        
 
<%@ include file="../rodape.jsp" %>