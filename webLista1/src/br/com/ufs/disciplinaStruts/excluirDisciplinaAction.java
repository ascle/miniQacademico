package br.com.ufs.disciplinaStruts;

import br.com.ufs.bean.Disciplina;
import br.com.ufs.jdbc.dao.DisciplinaDAO;

import com.opensymphony.xwork2.ActionSupport;

public class excluirDisciplinaAction extends ActionSupport {
	private DisciplinaDAO discDao;
	
	private String origem;
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	private String codDisciplina;	
	private String mensagemErro;
	private String mensagemSucesso;

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	@Override
	public String execute() throws Exception {
		discDao = new DisciplinaDAO();
		if( (discDao.getPrereq1(codDisciplina) != null) || (discDao.getPrereq2(codDisciplina) != null) ){
			mensagemErro = "\""+codDisciplina+"\""+" não pode ser removida, pois é um pré-requisito.";
		}else{		
			int status = discDao.excluir(codDisciplina);
			if ( status == DisciplinaDAO.NAO_EXISTE ){
				mensagemErro = "Disciplina não encontrada";
			}else if( status == DisciplinaDAO.REMOVIDO ){
				mensagemSucesso = "Disciplina removida com sucesso.";
			}else{
				mensagemErro = "\""+codDisciplina+"\""+" não pode ser removida, pois faz parte de algum curso.";
			} 
		}
		if( origem != null )
			if( origem.equals("listar") )
				return NONE;
		return SUCCESS;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	
}
