package br.com.ufs.cursoStruts;

import br.com.ufs.bean.Curso;
import br.com.ufs.jdbc.dao.CursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class BuscarCursoAction extends ActionSupport {	
	private String nomeCurso;
	private Curso curso;
	private CursoDAO cd;
	private String mensagemErro;
	
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}


	@Override
	public String execute() throws Exception {		
		cd = new CursoDAO();
		curso = cd.getCurso(nomeCurso.trim());
		if( curso == null ){
			mensagemErro = "Curso \""+nomeCurso.trim()+"\" não encontrado.";
			return NONE;	
		}
		return SUCCESS;
	}		


	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
}
