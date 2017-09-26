package br.com.ufs.cursoDisciplinaStruts;

import br.com.ufs.bean.Disciplina;
import br.com.ufs.bean.Disciplina_has_curso;
import br.com.ufs.jdbc.dao.CursoDAO;
import br.com.ufs.jdbc.dao.DisciplinaDAO;
import br.com.ufs.jdbc.dao.Disciplina_has_cursoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class incluirCursoDisciplinaAction extends ActionSupport {
	private String codDisciplina;
	private int codCurso;
	private int numPeriodo;
	private String tipoDisciplina;
	
	private String mensagemErro;
	private String mensagemSucesso;
	
	public void setNumPeriodo(int numPeriodo) {
		this.numPeriodo = numPeriodo;
	}
	public void setTipoDisciplina(String tipoDisciplina) {
		this.tipoDisciplina = tipoDisciplina;
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
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
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
		if( dcDao.getDC(codCurso, codDisciplina) != null){
			mensagemErro = "O curso \""+codCurso+"\" já possui a disciplina \""+codDisciplina+"\" cadastrada.";
			return SUCCESS;
		}
		
		// Verifica se os pré-requisitos da disciplina estão na grade do curso
		if( !disc.getPreReqDisciplina_2().trim().equals("") ){
			Disciplina_has_curso obj = dcDao.getDC(codCurso, disc.getPreReqDisciplina_2()); 
			if( obj == null ){
				mensagemErro = "Verifica se os pré-requisitos da disciplina \""+codDisciplina+"\" pertencem à grade do curso";
				return SUCCESS;
			}else{
				if( obj.getNumPeriodo() >= numPeriodo ){
					mensagemErro = "A disciplina \""+codDisciplina+"\" deverá pertencer à algum periodo superior ao(s) seu(s) pre-requisito.";
					return SUCCESS;
				}
			}
		}
		if( !disc.getPreReqDisciplina_1().trim().equals("") ){
			Disciplina_has_curso obj = dcDao.getDC(codCurso, disc.getPreReqDisciplina_1()); 
			if( obj == null ){
				mensagemErro = "Verifica se os pré-requisitos da disciplina \""+codDisciplina+"\" pertencem à grade do curso";
				return SUCCESS;
			}else{
				if( obj.getNumPeriodo() >= numPeriodo ){
					mensagemErro = "A disciplina \""+codDisciplina+"\" deverá pertencer à algum periodo superior ao(s) seu(s) pre-requisito.";
					return SUCCESS;
				}
			}
		}
		
		Disciplina_has_curso dis = new Disciplina_has_curso();
		dis.setCodCurso(codCurso);
		dis.setCodDisciplina(codDisciplina);
		dis.setNumPeriodo(numPeriodo);
		dis.setTipoDisciplina(tipoDisciplina);
		
		dcDao.insert(dis);
		mensagemSucesso = "Disciplina \""+codDisciplina+"\" cadastrada com sucesso no curso \""+codCurso+"\"";
		return SUCCESS;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}
	
}
