package br.com.ufs.cursoStruts;

import br.com.ufs.bean.Curso;
import br.com.ufs.jdbc.dao.CursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class incluirCursoAction extends ActionSupport {
	private String mensagemErro;
	private String mensagemSucesso;
	
	private String nomeCurso;
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	private Curso curso;
	private CursoDAO cd;

	public String getMensagemErro() {
		return mensagemErro;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	@Override
	public String execute() throws Exception {
		curso = new Curso();
		curso.setNomeCurso(nomeCurso.trim());
		
		cd = new CursoDAO();
		cd.insert(curso);
		mensagemSucesso = "Curso \""+nomeCurso.trim()+"\" inserido com sucesso. Seu código é \""+cd.getCurso(nomeCurso.trim()).getCodCurso()+"\".";
		
		return SUCCESS;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}		
}
