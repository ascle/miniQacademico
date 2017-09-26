package br.com.ufs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufs.bean.Disciplina;
import br.com.ufs.bean.Disciplina_has_curso;
import br.com.ufs.jdbc.ConnectionFactory;

public class DisciplinaDAO {
	private Connection connection;
	
	public static int REMOVIDO = 1;
	public static int NAO_EXISTE = 2;
	public static int EXISTE = 3;
	
	public DisciplinaDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void inserir( Disciplina disc ){
		String sql ="insert into disciplina "+
					"(codDisciplina,nomeDisciplina,numCreditosDisc,preReqDisciplina_1, preReqDisciplina_2)"+
					"values(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, disc.getCodDisciplina() );
			stmt.setString(2, disc.getNomeDisciplina() );
			stmt.setInt(3, disc.getNumCreditosDisc() );
			stmt.setString(4, disc.getPreReqDisciplina_1() );
			stmt.setString(5, disc.getPreReqDisciplina_2() );
						
			stmt.execute();					
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void alterar( Disciplina disc ){
		String sql = "update disciplina "+
				     "set nomeDisciplina = ?, numCreditosDisc = ?, preReqDisciplina_1 = ?, preReqDisciplina_2 = ? "+
				     "where codDisciplina = ?";
				
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
		
			stmt.setString(1, disc.getNomeDisciplina() );
			stmt.setInt(2, disc.getNumCreditosDisc() );
			stmt.setString(3, disc.getPreReqDisciplina_1() );
			stmt.setString(4, disc.getPreReqDisciplina_2() );
			stmt.setString(5, disc.getCodDisciplina() );
		
			stmt.execute();					
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public int excluir( String codDisciplina ) throws ClassNotFoundException{
		Disciplina_has_cursoDAO dcDao = new Disciplina_has_cursoDAO();
		int qtd = dcDao.getLista(codDisciplina).size(); 
		
		if( qtd == 0){		
			String sql = "delete from disciplina "+
			         "where codDisciplina = ?";
			boolean status = false;
			
			PreparedStatement stmt = null;
			try {	
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, codDisciplina );
				if( getDisciplina(codDisciplina) != null ){
					status = true; 
					stmt.execute();			
				}
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					stmt.close();
					if( status ){
						return REMOVIDO;
					}else{
						return NAO_EXISTE;
					}					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}else {
			return EXISTE;
		}
	}

	public List<Disciplina> getLista(){
		PreparedStatement stmt = null;
		List<Disciplina> listaDisc = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina");
			ResultSet result = stmt.executeQuery();
			
			listaDisc = new ArrayList<Disciplina>();
			
			while( result.next() ){
				// criando o objeto Contato
				Disciplina disc = new Disciplina();
				disc.setCodDisciplina(result.getString( "codDisciplina" ));
				disc.setNomeDisciplina(result.getString("nomeDisciplina"));
				disc.setNumCreditosDisc(result.getInt("numCreditosDisc"));
				disc.setPreReqDisciplina_1(result.getString("preReqDisciplina_1"));
				disc.setPreReqDisciplina_2(result.getString("preReqDisciplina_2"));
								
				listaDisc.add( disc );				
			}
			result.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try {
				stmt.close();				
			} catch (final SQLException e) {
				throw new RuntimeException(e);
			}			
		}
		return listaDisc;
	}

	public Disciplina getDisciplina( String codDisciplina ){
		PreparedStatement stmt = null;
		Disciplina disc = null;		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina where codDisciplina = ?");
			stmt.setString(1, codDisciplina);
			ResultSet result = stmt.executeQuery();			
			
			if( result.next() ){
				disc = new Disciplina();
				disc.setCodDisciplina(result.getString( "codDisciplina" ));
				disc.setNomeDisciplina(result.getString("nomeDisciplina"));
				disc.setNumCreditosDisc(result.getInt("numCreditosDisc"));
				disc.setPreReqDisciplina_1(result.getString("preReqDisciplina_1"));
				disc.setPreReqDisciplina_2(result.getString("preReqDisciplina_2"));															
			}
			result.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				try {
					stmt.close();				
				} catch (final SQLException e) {
					throw new RuntimeException(e);
				}			
			}
			return disc;
	}

	public List<Disciplina> getPrereq1( String codDisciplina ){
		PreparedStatement stmt = null;
		Disciplina disc = null;	
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina where preReqDisciplina_1 = ?");
			stmt.setString(1, codDisciplina);
			ResultSet result = stmt.executeQuery();			
			
			while( result.next() ){
				disc = new Disciplina();
				disc.setCodDisciplina(result.getString( "codDisciplina" ));
				disc.setNomeDisciplina(result.getString("nomeDisciplina"));
				disc.setNumCreditosDisc(result.getInt("numCreditosDisc"));
				disc.setPreReqDisciplina_1(result.getString("preReqDisciplina_1"));
				disc.setPreReqDisciplina_2(result.getString("preReqDisciplina_2"));	
				disciplinas.add(disc);
			}
			result.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				try {
					stmt.close();				
				} catch (final SQLException e) {
					throw new RuntimeException(e);
				}			
			}
			if( disciplinas.size() > 0 )
				return disciplinas;
			else
				return null;
	}

	public List<Disciplina> getPrereq2( String codDisciplina ){
		PreparedStatement stmt = null;
		Disciplina disc = null;		
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina where preReqDisciplina_2 = ?");
			stmt.setString(1, codDisciplina);
			ResultSet result = stmt.executeQuery();			
			
			while( result.next() ){
				disc = new Disciplina();
				disc.setCodDisciplina(result.getString( "codDisciplina" ));
				disc.setNomeDisciplina(result.getString("nomeDisciplina"));
				disc.setNumCreditosDisc(result.getInt("numCreditosDisc"));
				disc.setPreReqDisciplina_1(result.getString("preReqDisciplina_1"));
				disc.setPreReqDisciplina_2(result.getString("preReqDisciplina_2"));	
				disciplinas.add(disc);
			}
			result.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}finally{
				try {
					stmt.close();				
				} catch (final SQLException e) {
					throw new RuntimeException(e);
				}			
			}
		if( disciplinas.size() > 0 )
			return disciplinas;
		else
			return null;
	}
}
