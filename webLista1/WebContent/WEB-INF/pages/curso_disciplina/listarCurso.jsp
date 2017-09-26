<%@ include file="../head.jsp" %>

<div id="titulo_pg">Lista de Cursos</div>
	
	<br />
	<table border="1"> 
		<tr> 
			<td>Codigo</td>   	  
        	<td>Nome</td>        	
        </tr>
    	<s:iterator value="listaCurso" id="codCurso">      		    	
        	<tr>        		     
        		<td>
        			<s:property value="codCurso" />
        		</td>   	  
           		<td>           
           			<s:property value="nomeCurso" />           			
           		</td>           		
          		<td>	
          			<s:form namespace="disciplinaStruts" action="listarGradeActionB" method="post">
          				<s:hidden name="curso.codCurso" value="%{codCurso}" />
          				<s:hidden name="curso.nomeCurso" value="%{nomeCurso}" />
          				<s:hidden name="origem" value="listar" />
           				<s:submit value="Ver Grade" />
           			</s:form>	
           		</td>           		          			                                   
        	</tr>                		        
    	</s:iterator>
    </table>        
 
<%@ include file="../rodape.jsp" %>