package persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbMysql.DbConnection;
import dbMysql.QueryDbExecute;

public class Persona {
	private int ID;
	private String nome, cognome;

	// Mi crea la query per l'INSERT
	public static int Insert(Persona persona) {
		return QueryDbExecute.executeUpdate("INSERT INTO persone(Nome,Cognome) VALUES ('" + persona.getNome() + "','"
				+ persona.getCognome() + "')");
	}

	public static void Select(int ID) {
		querySelect("SELECT * FROM persone WHERE Persona_id = " + ID + "");
	}

	public static void Select() {
		querySelect("SELECT * FROM persone");
	}

	public static int Update(Persona persona) {
		return QueryDbExecute.executeUpdate("UPDATE persone SET Nome = '" + persona.getNome() + "', Cognome = '"
				+ persona.getCognome() + "' WHERE (persona_id = " + persona.getID() + ")");
	}

	public static int Delete(int ID) {
		return QueryDbExecute.executeUpdate("DELETE FROM persone WHERE (persona_id = " + ID + ")");
	}

	private static void querySelect(String pQuery) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), "root", "qwerty.1");
			stmt = conn.createStatement();
			rows = stmt.executeQuery(pQuery);
			while (rows.next()) {
				int selectId = rows.getInt("Persona_id");
				String selectNome = rows.getString("Nome");
				String selectCognome = rows.getString("Cognome");
				System.out.println("id:" + selectId + " Nome:" + selectNome + " Cognome:" + selectCognome);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
