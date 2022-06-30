package sakila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbMysql.DbConnection;

public class SakilaSelect {
	
	public static void selectIntervalloID(int id1, int id2) {
		select("customer_id >= "+id1+" AND customer_id <= "+id2);
	}
	
	public static void selectById(int pId) {
		select("customer_id = " + pId);
	}

	private static void select(String pWhere) {
		// ** definisco la query select
		String query = "SELECT customer_id,first_name,last_name,city.city FROM sakila.customer, sakila.address INNER JOIN sakila.city";
		if (pWhere != null || pWhere.length() > 0) {
			query += " " + "WHERE " + pWhere+" AND customer.address_id = address.address_id AND address.city_id = city.city_id ORDER BY first_name";
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(query);
			while (rows.next()) {
				// legge tutte le righe/records contenute in rows
				// fino a rows.next = false;
				// ovvero raggiunto EOF (End Of File)
				/* 4 lETTURA ResultSet */
				int id = rows.getInt("customer_id");
				String nome = rows.getString("first_name");
				String cognome = rows.getString("last_name");
				String citta = rows.getString("city");
				System.out.println("id:" + id + " Nome:" + nome + " Cognome:" + cognome + " city:"+citta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rows != null)
					stmt.close();
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

	}

	public static void SelectAll() {
		// ** definisco la query select
		String query = "SELECT customer_id,first_name,last_name FROM customer";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(query);
			while (rows.next()) {
				// legge tutte le righe/records contenute in rows
				// fino a rows.next = false;
				// ovvero raggiunto EOF (End Of File)
				/* 4 lETTURA ResultSet */
				int id = rows.getInt("customer_id");
				String nome = rows.getString("first_name");
				String cognome = rows.getString("last_name");
				System.out.println("id:" + id + " Nome:" + nome + " Cognome:" + cognome);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rows != null)
					stmt.close();
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
	}
}
