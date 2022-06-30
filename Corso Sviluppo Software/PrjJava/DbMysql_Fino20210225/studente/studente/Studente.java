package studente;

import java.sql.*;

import dbMysql.DbConnection;

public class Studente {

	//definisco le variabili
	private int idUtente;	// readOnly
	private int numeroTessera;
	private String cognome;
	private String nome;
	private String indirizzoResidenza;
	
	public int getIdUtente() {
		return idUtente;
	}
	
	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}
	
	public int getNumeroTessera() {
		return numeroTessera;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	
	public void insertToDatabase() {
		
	}
	
	public void insertToDatabase_01() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			/* 1 Connessione */
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(), DbConnection.getDb().getPassword());
			/* 2 Statement */
			stmt = conn.createStatement();
			/* 3 Esecuzione query */
			String query = "INSERT INTO utente(numeroTessera,nome,cognome,indirizzoResidenza) VALUES (21,\"Lorenzi\",\"Luca\",\"Via Pisa, 63\");";			
			int i = stmt.executeUpdate(query);
			System.out.println("Record aggiunti: " + i);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			/* 4 Chiusura connessione */
			try { if(conn!=null) { conn.close(); } } catch (SQLException e1) { e1.printStackTrace(); }
			try { if(stmt!=null) { stmt.close(); } } catch (SQLException e1) { e1.printStackTrace(); }			
		}
	}
	
	public void insertToDatabase_02() {
		Connection conn = null;
		Statement stmt = null;
		String query = "INSERT INTO utente(numeroTessera,nome,cognome,indirizzoResidenza) VALUES (31,\"Lorenzi\",\"Luca\",\"Via Pisa, 63\");";			
		String query2 = "INSERT INTO utente(numeroTessera,nome,cognome,indirizzoResidenza) VALUES (32,\"Alfieri\",\"Giacomo\",\"Via Pisa, 63\");";			
		query = query+query2;
		try {
			/* 1 Connessione */
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(), DbConnection.getDb().getPassword());
			/* 2 Statement */
			stmt = conn.createStatement();
			/* 3 Esecuzione query */
			int i = stmt.executeUpdate(query);
			System.out.println("Record aggiunti: " + i);			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			/* 4 Chiusura connessione */
			try { if(conn!=null) { conn.close(); } } catch (SQLException e1) { e1.printStackTrace(); }
			try { if(stmt!=null) { stmt.close(); } } catch (SQLException e1) { e1.printStackTrace(); }			
		}
	}	

	public void insertToDatabase_03() {
		Connection conn = null;
		Statement stmt = null;
		String query = "INSERT INTO utente(numeroTessera,nome,cognome,indirizzoResidenza) VALUES "
				+ "(101,\"Lorenzi1\",\"Luca\",\"Via Pisa, 63\"),"
				+ "(102,\"Lorenzi2\",\"Luca\",\"Via Pisa, 63\"), "
				+ "(103,\"Lorenzi3\",\"Luca\",\"Via Pisa, 63\");";			
		try {
			/* 1 Connessione */
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(), DbConnection.getDb().getPassword());
			/* 2 Statement */
			stmt = conn.createStatement();
			/* 3 Esecuzione query */
			int i = stmt.executeUpdate(query);
			System.out.println("Record aggiunti: " + i);			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			/* 4 Chiusura connessione */
			try { if(conn!=null) { conn.close(); } } catch (SQLException e1) { e1.printStackTrace(); }
			try { if(stmt!=null) { stmt.close(); } } catch (SQLException e1) { e1.printStackTrace(); }			
		}
	}	

}