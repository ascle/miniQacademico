<%@ include file="../head.jsp" %>

<div id="titulo_pg">Grade Curricular - <s:property value="%{curso.nomeCurso}"/></div> 
	<br />
	<table cellspacing="3" border="2">  
		<tr> 
			<td>Periodo</td>   	  
        	<td>Codigo da Materia</td>
        	<td>Nome da Materia</td>
        	<td>Tipo Matéria</td>
        	<td>Pre-req 1</td>
        	<td>Pre-req 2</td>
        </tr>
        <%int count = 0;%>
    	<s:iterator value="listaDc" id="nomeDisciplina">
    	<% if( count%2 == 0 ) {%>      		    	
        	<tr style="background-color:grey">
        <%}else{ %>
        	<tr>
        <%} %>	        	  
           		<td>           
           			<s:property value="numPeriodo" />
           		</td>
           		<td>	
           			<s:property value="codDisciplina" />
           		</td>	
           		<td>	
           			<s:property value="nomeDisciplina" />
           		</td>
           		<td>	
           			<s:property value="tipoDisciplina" />
           		</td>	
           		<td>	
           			<s:property value="pre1" />
           		</td>
           		<td>	
           			<s:property value="pre2" />
           		</td>	
           		<td>	
           			<s:form namespace="disciplinaStruts" action="excluirCursoDisciplinaAction" method="post">
           				<s:hidden name="codCurso" value="%{codCurso}" />
           				<s:hidden name="codDisciplina" value="%{codDisciplina}" />
           				<s:submit value="Remover" />  
           			</s:form>	         	
          		</td>                                   
        	</tr> 
        	<% count++; %>       		        
    	</s:iterator>
    </table>

<%@ include file="../rodape.jsp" %>