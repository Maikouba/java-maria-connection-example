package br.edu.ifsp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaDatabase implements Database {

	private String username;
	
	private String password;

	private String databaseName;
	
	private String host;
	
	private int port;
	
	private Connection connection;
	
	public MariaDatabase(String username, String password, String databaseName, String host, int port) {
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
		this.host = host;
		this.port = port;
	}
	
	public MariaDatabase(String username, String password, String databaseName, String host) {
		this(username, password, databaseName, host, 3306);
	}
	
	public MariaDatabase(String username, String password, String databaseName) {
		this(username, password, databaseName, "localhost", 3306);
	}
	
	public boolean connect() {
		
		boolean result = true;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			if (connection != null)
				connection.close();
			
			this.connection = 
				DriverManager.getConnection(
					"jdbc:mariadb://" + this.host + ":" + port + "/" + this.databaseName,
					this.username, this.password);
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet query(String sql) {
		
		ResultSet result = null;
		
		try {
			
			if (connection != null && !connection.isClosed()) {
				
				
				PreparedStatement statement = this.connection.prepareStatement(sql);
				
				result = statement.executeQuery();
			
			} else 			
				throw new Exception("Database is not connected.");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean disconnect() {
		
		boolean result = false;
		
		try {
		
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				result = true;
			}
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}
}
