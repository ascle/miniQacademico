package br.com.ufs.disciplinaStruts;

import java.util.List;

import br.com.ufs.bean.Disciplina;
import br.com.ufs.jdbc.dao.DisciplinaDAO;

import com.opensymphony.xwork2.ActionSupport;

public class listarDisciplinaAction extends ActionSupport {
	private DisciplinaDAO discDao;
	private Disciplina disciplina;	
	private String mensagemErro;
	private String mensagemSucesso;
	private List<Disciplina> listaDisc;
	
	@Override
	public String execute() throws Exception {
		discDao = new DisciplinaDAO();
		listaDisc = discDao.getLista();
		
		if( listaDisc == null ){
			this.mensagemErro = "Não há disciplinas cadastradas no sistema";
		}		
		return SUCCESS;
	}
	
	public String getMensagemErro() {
		return mensagemErro;
	}

	public List<Disciplina> getListaDisc() {
		return listaDisc;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	
	
	
}
