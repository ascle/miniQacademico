package br.com.ufs.cursoDisciplinaStruts;

import java.util.List;

import br.com.ufs.bean.Curso;
import br.com.ufs.jdbc.dao.CursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class listarCursoAction extends ActionSupport{
	private CursoDAO cd;
	private Curso curso;	
	private String mensagemErro;
	private String mensagemSucesso;
	private List<Curso> listaCurso;
			
	@Override
	public String execute() throws Exception {
		cd = new CursoDAO();
		listaCurso = cd.getLista();
		
		if( listaCurso == null ){
			this.mensagemErro = "Não há disciplinas cadastradas no sistema";
		}		
		return SUCCESS;
	}
	
	public CursoDAO getCd() {
		return cd;
	}
	public void setCd(CursoDAO cd) {
		this.cd = cd;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	public String getMensagemSucesso() {
		return mensagemSucesso;
	}
	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}
	public List<Curso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	
	
}
