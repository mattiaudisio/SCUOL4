package sakila;

import java.sql.*;
import dbMysql.*;


public class ConnessioneMySql {

	public static void main(String[] args) {
		try {
			createConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nProgramma Terminato");
	}

	private static void createConnection() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		try {
			/* 1 CONNESSIONE AL DATABASE */
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), "root","qwerty.1");
			System.out.println("Connessione eseguita");

			/* 2 CREAZIONE DELLO STATEMENT */
			stmt = conn.createStatement();
			System.out.println("Statement creato");

			/* 3 INVIO DELLA QUERY */
			String query = "SELECT customer_id,first_name,last_name FROM customer";
			rows = stmt.executeQuery(query);
			System.out.println("Query eseguita");

			/* 4 lETTURA ResultSet */
			System.out.println("\n**ELENCO TRATTO DA CUSTOMER**");
			while (rows.next()) {
				int id = rows.getInt("customer_id");
				String nome = rows.getString("first_name");
				String cognome = rows.getString("last_name");
				System.out.println("id:" + id + " Nome:" + nome + " Cognome:" + cognome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* 3 */ try {
				if (rows != null)
					rows.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 2 */ try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/* 1 */ try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
