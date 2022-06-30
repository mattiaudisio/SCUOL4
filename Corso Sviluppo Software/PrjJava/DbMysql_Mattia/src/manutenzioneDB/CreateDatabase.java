//Daniele Gribaudo



package manutenzioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dbMysql.DbConnection;

public class CreateDatabase {
	
	private String nomeDatabase;
	
	public String getNomeDB() {
		return nomeDatabase;
	}



	public CreateDatabase(String value) {
		nomeDatabase=value;
		
	}
	
	
	
	public static CreateDatabase createDB(String pNomeDB) {
		CreateDatabase db= new CreateDatabase(pNomeDB);
		return db;
		
	}
	
	
	
	public void buildDB() {
		
		Connection conn=null;
		Statement stmt=null;
		String query="CREATE DATABASE IF NOT EXISTS " +getNomeDB()+";" ;
		
		try {
			conn= DriverManager.getConnection(DbConnection.getDb().getDriverWithoutDbName(),DbConnection.getDb().getUsername(),DbConnection.getDb().getPassword());
			stmt=conn.createStatement();
			stmt.execute(query);
			System.out.print("Query eseguita");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			/*2*/try {if (stmt!=null) stmt.close();} catch (SQLException e) {e.printStackTrace();}
			/*1*/try {if (conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	

}
