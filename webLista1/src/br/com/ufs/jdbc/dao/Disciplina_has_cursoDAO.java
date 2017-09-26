package br.com.ufs.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufs.bean.Disciplina_has_curso;
import br.com.ufs.jdbc.ConnectionFactory;

public class Disciplina_has_cursoDAO {
	private Connection connection;
	
	public Disciplina_has_cursoDAO() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert( Disciplina_has_curso dc ){
		String sql = "insert into disciplina_has_curso (disciplina_codDisciplina, curso_codCurso, numPeriodo, tipoDisciplina)" + 
					 "values(?,?,?,?)";
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			stmt.setString(1 , dc.getCodDisciplina() );
			stmt.setInt(2, dc.getCodCurso() );
			stmt.setInt(3, dc.getNumPeriodo());
			stmt.setString(4, dc.getTipoDisciplina());
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

	public void Remove( Disciplina_has_curso dc ){
		String sql = "delete from disciplina_has_curso where disciplina_codDisciplina = ? and curso_codCurso = ?";
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			stmt.setString(1 , dc.getCodDisciplina() );
			stmt.setInt(2, dc.getCodCurso() );			
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

	
	public List<Disciplina_has_curso> getLista( int codCurso ){
		PreparedStatement stmt = null;
		List<Disciplina_has_curso> lista = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina_has_curso where curso_codCurso = ? ORDER BY numPeriodo");
			stmt.setInt(1, codCurso );
			ResultSet result = stmt.executeQuery();
			
			lista = new ArrayList<Disciplina_has_curso>();
			
			while( result.next() ){
				Disciplina_has_curso dc = new Disciplina_has_curso();
				dc.setCodDisciplina(result.getString("disciplina_codDisciplina"));
				dc.setCodCurso(result.getInt("curso_codCurso"));
				dc.setNumPeriodo(result.getInt("numPeriodo"));
				dc.setTipoDisciplina(result.getString("tipoDisciplina"));
				lista.add( dc );				
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
		return lista;
	}
	
	public List<Disciplina_has_curso> getLista( String codDisciplina ){
		PreparedStatement stmt = null;
		List<Disciplina_has_curso> lista = new ArrayList<Disciplina_has_curso>();
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina_has_curso where disciplina_codDisciplina = ?");
			stmt.setString(1, codDisciplina );
			ResultSet result = stmt.executeQuery();
			
			
			while( result.next() ){
				Disciplina_has_curso dc = new Disciplina_has_curso();
				dc.setCodDisciplina(result.getString("disciplina_codDisciplina"));
				dc.setCodCurso(result.getInt("curso_codCurso"));
				dc.setNumPeriodo(result.getInt("numPeriodo"));
				dc.setTipoDisciplina(result.getString("tipoDisciplina"));
				lista.add( dc );				
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
		return lista;
	}

	public Disciplina_has_curso getDC( int codCurso , String codDisciplina ){
		PreparedStatement stmt = null;
		Disciplina_has_curso dc = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  disciplina_has_curso where disciplina_codDisciplina = ? And curso_codCurso = ?");
			stmt.setString(1, codDisciplina );
			stmt.setInt( 2, codCurso);
			ResultSet result = stmt.executeQuery();
			
			
			if( result.next() ){
				dc = new Disciplina_has_curso();
				dc.setCodDisciplina(result.getString("disciplina_codDisciplina"));
				dc.setCodCurso(result.getInt("curso_codCurso"));
				dc.setNumPeriodo(result.getInt("numPeriodo"));
				dc.setTipoDisciplina(result.getString("tipoDisciplina"));								
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
		return dc;
	}
}
