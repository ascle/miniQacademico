package br.com.ufs.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ufs.bean.Curso;
import br.com.ufs.jdbc.ConnectionFactory;

public class CursoDAO {
	private Connection connection;
		
	public CursoDAO() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert( Curso curso ){
		String sql ="insert into curso" + "(nomeCurso)" + "values(?)";
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			stmt.setString(1 , curso.getNomeCurso());
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

	public void alterar( Curso curso ){
		String sql ="update curso set nomeCurso = ? where codCurso = ?";
		
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			stmt.setString(1 , curso.getNomeCurso());
			stmt.setInt(2 , curso.getCodCurso());
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

	public void excluir( int codCurso ){
		String sql ="delete from curso where codCurso = ?";
			
		PreparedStatement stmt = null;
		try {	
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1 , codCurso );
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
	
	public List<Curso> getLista(){
		PreparedStatement stmt = null;
		List<Curso> listaCursos = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  curso");
			ResultSet result = stmt.executeQuery();
			
			listaCursos = new ArrayList<Curso>();
			
			while( result.next() ){
				Curso curso = new Curso();
				curso.setCodCurso( result.getInt("codCurso") );
				curso.setNomeCurso(result.getString("nomeCurso"));
								
				listaCursos.add( curso );				
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
		return listaCursos;
	}

	public Curso getCurso( int codCurso ){
		PreparedStatement stmt = null;
		Curso curso = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  curso where codCurso = ?");
			stmt.setInt(1, codCurso );
			ResultSet result = stmt.executeQuery();
			
			if( result.next() ){
				curso = new Curso();
				curso.setCodCurso( result.getInt("codCurso") );
				curso.setNomeCurso(result.getString("nomeCurso"));			
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
		return curso;
	}

	public Curso getCurso( String nomeCurso ){
		PreparedStatement stmt = null;
		Curso curso = null;
		
		try{
			stmt = connection.prepareStatement("SELECT * FROM  curso where nomeCurso = ?");
			stmt.setString(1, nomeCurso );
			ResultSet result = stmt.executeQuery();
			
			if( result.next() ){
				curso = new Curso();
				curso.setCodCurso( result.getInt("codCurso") );
				curso.setNomeCurso(result.getString("nomeCurso"));			
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
		return curso;
	}
	
}
