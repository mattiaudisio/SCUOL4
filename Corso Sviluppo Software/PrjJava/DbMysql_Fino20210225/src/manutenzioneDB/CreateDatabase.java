/*
 *  M A T T I A  A U D I S I O  * 
 */

package manutenzioneDB;

import java.sql.*;
import dbMysql.*;

public class CreateDatabase {

	private static String nomeDatabase = "";

	public CreateDatabase(String nome) {
		nomeDatabase = nome;
	}

	public static CreateDatabase createDB(String nomeDB) {
		CreateDatabase db = new CreateDatabase(nomeDB);
		return db;
	}

	public void BuildDatabase() { // Crea il database
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriverWithoutDbName(),DbConnection.getDb().getUserName(),DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			String query = "CREATE DATABASE IF NOT EXISTS " + getNomeDatabase() + ";";
			boolean i = stmt.execute(query);
			System.out.println("Boolean database: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static String getNomeDatabase() {
		return nomeDatabase;
	}
}
