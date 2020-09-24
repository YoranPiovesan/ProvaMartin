package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoHSQLDB {
	private String usuario =  "SA";
	private String senha = "";
	private String pathBase = "C:\\Users\\Pichau\\eclipse-workspace\\ProvaMartin\\Dados\\Pessoa";
	private String URL =  "jdbc:hsqldb:file:" + pathBase +";";
	
	public Connection conectar() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {	
			e.printStackTrace();
			return null;
		}
	}
}
