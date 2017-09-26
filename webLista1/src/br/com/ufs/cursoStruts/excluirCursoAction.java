package br.com.ufs.cursoStruts;

import br.com.ufs.bean.Curso;
import br.com.ufs.jdbc.dao.CursoDAO;
import br.com.ufs.jdbc.dao.Disciplina_has_cursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class excluirCursoAction extends ActionSupport {
	private String mensagemErro;
	private String mensagemSucesso;
	
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	private int codCurso;
	
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	private CursoDAO cd;

	public String getMensagemErro() {
		return mensagemErro;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	@Override
	public String execute() throws Exception {
		cd = new CursoDAO();
		Disciplina_has_cursoDAO  disc_curso = new Disciplina_has_cursoDAO();
		
		if( cd.getCurso(codCurso) == null ){
			mensagemErro = "Curso \""+ codCurso +"\" não encontrado.";
			return SUCCESS;
		}else if( disc_curso.getLista(codCurso).size() > 0 ){
			mensagemErro = "Curso \""+ codCurso +"\" não pode ser removido, pois existe disciplinas en sua grade.";
			return SUCCESS;
		}
		cd.excluir(codCurso);
		mensagemSucesso = "Curso \""+codCurso+"\" removido com sucesso.";
		
		return SUCCESS;
	}		
}
