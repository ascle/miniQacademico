package br.com.ufs.bean;

import br.com.ufs.jdbc.dao.*;

public class Disciplina_has_curso {
	private String codDisciplina;
	private int codCurso;
	private int numPeriodo;
	private String tipoDisciplina;
	
	public String getNomeDisciplina() throws ClassNotFoundException {
		DisciplinaDAO cd = new DisciplinaDAO();		
		return cd.getDisciplina(codDisciplina).getNomeDisciplina();
	}
	public String getPre1() throws ClassNotFoundException {
		DisciplinaDAO cd = new DisciplinaDAO();		
		return cd.getDisciplina(codDisciplina).getPreReqDisciplina_1();
	}
	public String getPre2() throws ClassNotFoundException {
		DisciplinaDAO cd = new DisciplinaDAO();		
		return cd.getDisciplina(codDisciplina).getPreReqDisciplina_2();
	}
	
	public String getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public int getNumPeriodo() {
		return numPeriodo;
	}
	public void setNumPeriodo(int numPeriodo) {
		this.numPeriodo = numPeriodo;
	}
	public String getTipoDisciplina() {
		return tipoDisciplina;
	}
	public void setTipoDisciplina(String tipoDisciplina) {
		this.tipoDisciplina = tipoDisciplina;
	}
	
}
