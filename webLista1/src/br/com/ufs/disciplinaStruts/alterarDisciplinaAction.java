package br.com.ufs.disciplinaStruts;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ufs.jdbc.dao.DisciplinaDAO;
import br.com.ufs.bean.Disciplina;

public class alterarDisciplinaAction extends ActionSupport {
	
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	private String codDisciplina;
	private String nomeDisciplina;
	private String numCreditosDisc;
	private String preReqDisciplina_1;
	private String preReqDisciplina_2;
	
	private String mensagemErro;
	private String mensagemSucesso;
	
	private DisciplinaDAO discDao;
	private Disciplina disciplina;
	
	private String origem;
	
	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNumCreditosDisc() {
		return numCreditosDisc;
	}

	public void setNumCreditosDisc(String numCreditosDisc) {
		this.numCreditosDisc = numCreditosDisc;
	}

	public String getPreReqDisciplina_1() {
		return preReqDisciplina_1;
	}

	public void setPreReqDisciplina_1(String preReqDisciplina_1) {
		this.preReqDisciplina_1 = preReqDisciplina_1;
	}

	public String getPreReqDisciplina_2() {
		return preReqDisciplina_2;
	}

	public void setPreReqDisciplina_2(String preReqDisciplina_2) {
		this.preReqDisciplina_2 = preReqDisciplina_2;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	@Override
	public String execute() throws Exception {
		disciplina = new Disciplina();
		disciplina.setCodDisciplina(codDisciplina);
		disciplina.setNomeDisciplina(nomeDisciplina);
		disciplina.setNumCreditosDisc(Integer.parseInt(numCreditosDisc));
		disciplina.setPreReqDisciplina_1(preReqDisciplina_1);
		disciplina.setPreReqDisciplina_2(preReqDisciplina_2);
		
		discDao = new DisciplinaDAO();
		if( discDao.getDisciplina(codDisciplina) == null){
			mensagemErro = "Disciplina \""+codDisciplina+"\" não encontra.";			
			return SUCCESS;
		}else if( (!preReqDisciplina_1.trim().equals("")) && (discDao.getDisciplina(preReqDisciplina_1)) == null ){
			mensagemErro = "Pré-requisito 1 \""+preReqDisciplina_1+"\" não encontrado.";			
			return SUCCESS;
		}else if( (!preReqDisciplina_2.trim().equals("")) && (discDao.getDisciplina(preReqDisciplina_2)) == null ){
			mensagemErro = "Pré-requisito 2 \""+preReqDisciplina_2+"\" não encontrado.";			
			return SUCCESS;
		}
				
		discDao.alterar(disciplina);
		mensagemSucesso = "Disciplina \""+codDisciplina+"\" alterda com sucesso";		
		return SUCCESS;
	}
	
}
