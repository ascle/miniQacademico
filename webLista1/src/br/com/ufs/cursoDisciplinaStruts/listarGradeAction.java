package br.com.ufs.cursoDisciplinaStruts;

import java.util.List;

import br.com.ufs.bean.Curso;
import br.com.ufs.bean.Disciplina;
import br.com.ufs.bean.Disciplina_has_curso;
import br.com.ufs.jdbc.dao.DisciplinaDAO;
import br.com.ufs.jdbc.dao.Disciplina_has_cursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class listarGradeAction extends ActionSupport {
	private String mensagemErro;
	private String mensagemSucesso;
	
	private Curso curso;
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	private Disciplina_has_cursoDAO dcDao;		
	private List<Disciplina_has_curso> listaDc;
	
	@Override
	public String execute() throws Exception {
		dcDao = new Disciplina_has_cursoDAO();
		listaDc = dcDao.getLista( curso.getCodCurso() );
		
		if( listaDc.size() == 0 ){
			this.mensagemErro = "Não há disciplinas cadastradas neste curso";
		}		
		return SUCCESS;
	}

	public Disciplina_has_cursoDAO getDcDao() {
		return dcDao;
	}

	public void setDcDao(Disciplina_has_cursoDAO dcDao) {
		this.dcDao = dcDao;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	public Curso getCurso() {
		return curso;
	}

	public List<Disciplina_has_curso> getListaDc() {
		return listaDc;
	}
	
	
}
