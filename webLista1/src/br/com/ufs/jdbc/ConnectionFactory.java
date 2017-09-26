package br.com.ufs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			Class.forName("org.postgresql.Driver");  
			return DriverManager.getConnection(	"jdbc:postgresql://localhost/pweb1", "postgres", "starslayer");
			
//		    Class.forName("com.mysql.jdbc.Driver");  
//			return DriverManager.getConnection(	"jdbc:mysql://localhost/pweb1", "root", "123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
