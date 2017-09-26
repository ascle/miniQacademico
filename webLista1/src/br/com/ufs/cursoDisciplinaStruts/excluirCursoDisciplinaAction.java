package br.com.ufs.cursoDisciplinaStruts;

import java.util.Iterator;
import java.util.List;


import br.com.ufs.bean.Disciplina;
import br.com.ufs.bean.Disciplina_has_curso;
import br.com.ufs.jdbc.dao.CursoDAO;
import br.com.ufs.jdbc.dao.DisciplinaDAO;
import br.com.ufs.jdbc.dao.Disciplina_has_cursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class excluirCursoDisciplinaAction extends ActionSupport {
	private String codDisciplina;
	private int codCurso;
	
	private String mensagemErro;
	private String mensagemSucesso;
	
	
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public String getMensagemSucesso() {
		return mensagemSucesso;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
		
	
	@Override
	public String execute() throws Exception {
		DisciplinaDAO discDao = new DisciplinaDAO();
		Disciplina disc = discDao.getDisciplina(codDisciplina);
		
		// Verifica se existe disciplina com o codigo informado
		if( disc == null){
			mensagemErro = "Disciplina \""+codDisciplina+"\" não encontrada.";
			return SUCCESS;
		}
				
		
		// Verifica se existe o curso informado
		CursoDAO cd = new CursoDAO();
		if( cd.getCurso(codCurso) == null){
			mensagemErro = "Curso \""+codCurso+"\" não encontrado.";
			return SUCCESS;
		}
			
		Disciplina_has_cursoDAO dcDao = new Disciplina_has_cursoDAO();
		Disciplina_has_curso dc = dcDao.getDC(codCurso, codDisciplina);
		if( dc != null ){
			List<Disciplina> pr1 = discDao.getPrereq1(codDisciplina);
			List<Disciplina> pr2 = discDao.getPrereq2(codDisciplina);
			
			if( pr1 != null){
				Iterator it1 = pr1.iterator();
				while(it1.hasNext()) {
					Disciplina element = (Disciplina) it1.next();
			         if( dcDao.getDC(codCurso, element.getCodDisciplina()) != null ){
			        	 mensagemErro = "\""+codDisciplina+"\""+" não pode ser removida, pois é um pré-requisito de \""+element.getCodDisciplina()+"\".";
			        	 return SUCCESS;
			         }
			     }
			}else if( pr2 != null){
				Iterator it2 = pr2.iterator();
				while(it2.hasNext()) {
					Disciplina element = (Disciplina) it2.next();
			         if( dcDao.getDC(codCurso, element.getCodDisciplina()) != null ){
			        	 mensagemErro = "\""+codDisciplina+"\""+" não pode ser removida, pois é um pré-requisito de \""+element.getCodDisciplina()+"\".";
			        	 return SUCCESS;
			         }
			     }				
			}
			dcDao.Remove(dc);				
			mensagemSucesso = "Disciplina removida com sucesso.";							
		}
		else
			mensagemErro = "\""+codDisciplina+"\""+" não foi encontra no curso.";
		
		
		return SUCCESS;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}				

	
	}
