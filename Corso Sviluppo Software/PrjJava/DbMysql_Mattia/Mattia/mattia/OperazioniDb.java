package mattia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbMysql.DbConnection;
import dbMysql.QueryDbExecute;

public class OperazioniDb {

	public static int Insert(String txtNome, String txtUnitaMisura, int txtQuantita, double txtPrezzo,
			boolean txtAttivo, String txtDescrizione) {
		String query = "INSERT INTO articoli(nomeArticolo,descrizione,unitaMisura,quantita,prezzo,attivo) VALUES ('"
				+ txtNome + "','" + txtDescrizione + "','" + txtUnitaMisura + "'," + txtQuantita + "," + txtPrezzo + ","
				+ txtAttivo + ")";
		DbConnection.getDb().setNomeDb("veicoli");
		return QueryDbExecute.executeUpdate(query);
	}

	public static Articolo Select(int ID) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		Articolo articolo = new Articolo();
		DbConnection.getDb().setNomeDb("veicoli");
		// ** Ricerca singola persona by Persona_ID
		String query = "SELECT * FROM articoli WHERE idArticoli = '" + ID + "'";
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(query);
			while (rows.next()) {
				articolo.setNomeArticolo(rows.getString("nomeArticolo"));
				articolo.setDescrizione(rows.getString("descrizione"));
				articolo.setUnitaMisura(rows.getString("unitaMisura"));
				articolo.setQuantita(rows.getInt("quantita"));
				articolo.setPrezzo(rows.getDouble("prezzo"));
				articolo.setAttivo(rows.getBoolean("attivo"));
				return articolo;
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
		return null;
	}

	public static int Delete(int ID) {
		DbConnection.getDb().setNomeDb("veicoli");
		return QueryDbExecute.executeUpdate("DELETE FROM articoli WHERE (idArticoli = " + ID + ")");
	}

	public static int Update(int ID, String txtNome, String txtUnitaMisura, int txtQuantita, double txtPrezzo,
			boolean txtAttivo, String txtDescrizione) {
		DbConnection.getDb().setNomeDb("veicoli");
		String query = "UPDATE articoli SET nomeArticolo = '" + txtNome + "',descrizione = '" + txtDescrizione
				+ "',unitaMisura = '" + txtUnitaMisura + "',quantita = " + txtQuantita + ",prezzo = " + txtPrezzo
				+ ",attivo= " + txtAttivo + " WHERE (idArticoli = '" + ID + "')";
		return QueryDbExecute.executeUpdate(query);
	}
}
