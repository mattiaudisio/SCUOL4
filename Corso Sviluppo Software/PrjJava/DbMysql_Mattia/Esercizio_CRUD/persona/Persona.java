package persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbMysql.DbConnection;
import dbMysql.QueryDbExecute;

public class Persona{
	private int ID;
	private String nome, cognome;

	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.setCognome("Audisio");
		persona.setnome("Mattia");
		DbConnection.getDb().setNomeDb("veicoli");
	}

	// Mi crea la query per l'INSERT
	public static int Insert(Persona persona) {
		String query = "INSERT INTO persone(Nome,Cognome) VALUES ('" + persona.getNome() + "','" + persona.getCognome()
				+ "')";
		DbConnection.getDb().setNomeDb("veicoli");
		return QueryDbExecute.executeUpdate(query);
	}

	public static Persona Select(int ID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		Persona persona = new Persona();
		DbConnection.getDb().setNomeDb("veicoli");
		// ** Ricerca singola persona by Persona_ID
		String query = "SELECT * FROM persone WHERE Persona_id = " + ID + "";
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(query);
			while (rows.next()) {
				// ** Se la query torna una riga esegue questo blocco di codice
				// ** Legge nome da ResultSet
				persona.setnome(rows.getString("Nome"));
				// ** Legge cognome da ResultSet
				persona.setCognome(rows.getString("Cognome"));
				// ** Assegna i dati ritrovati con la SELECT all'oggetto
				persona.ID = rows.getInt("Persona_id");
				// ** Ritorno oggetto persona
				return persona;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rows != null)
					rows.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// ** Non ho trovato record corrispondente all'ID passato come parametro
		return null;
	}

	public static void Select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		String query = "SELECT * FROM persone";
		DbConnection.getDb().setNomeDb("veicoli");
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(query);
			// lettura di tutte le righe
			while (rows.next()) {
				// legge tutti i record contenuti in rows fino a
				// rows.next=false, ovvero raggiunto EOF, End Of File

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return result;
		} finally {
			/* 3 */try {
				if (rows != null)
					rows.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 2 */try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 1 */try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int Update(Persona persona) {
		DbConnection.getDb().setNomeDb("veicoli");
		return QueryDbExecute.executeUpdate("UPDATE persone SET Nome = '" + persona.getNome() + "', Cognome = '"
				+ persona.getCognome() + "' WHERE (persona_id = " + persona.getID() + ")");
	}

	public static int Delete(int ID) {
		DbConnection.getDb().setNomeDb("veicoli");
		return QueryDbExecute.executeUpdate("DELETE FROM persone WHERE (persona_id = " + ID + ")");
	}

	public int getID() {
		return this.ID;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCognome() {
		return this.cognome;
	}

}