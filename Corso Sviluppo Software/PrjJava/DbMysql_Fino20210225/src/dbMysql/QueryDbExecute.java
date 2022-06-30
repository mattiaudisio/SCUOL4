package dbMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * - Classe non ereditabile (final)
 * - Di questa classe non è possibile creare un oggetto (costruttore privato)
 * 	 in quanto contiene solo metodi statici
 */
public final class QueryDbExecute {

	/*
	 * essendo privato non è possibile costruire l'oggetto
	 */
	// Ci permette di NON creare degli oggetti di questa Classe
	private QueryDbExecute() {

	}

	/*
	 * metodo da richiamare per CREATE TABLE, ALTER, DROP, TRONCATE
	 * 
	 * @param pQuery
	 * 
	 * @return True se esecuzione sql andata a buon fine
	 */
	public static boolean execute(String pQuery) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			stmt.execute(pQuery);
			return true;
			// ** intercetta solo errori generati da java.sql
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
			// ** intercetta tutti gli altri errori in quanto utilizza la classe base
			// exception
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
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

	/*
	 * Questo metodo è da utilizzare SOLO per creare un nuovo db
	 * 
	 * @param pQuery conterrà "CREATE DB"
	 * 
	 * @return True se db creato con successo
	 */
	public static boolean CreazioneDatabase(String pQuery) {
		// deVono essere dichiarati al di fuori del Try in quanto utilizzate anche nel
		// blocco finally
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriverWithoutDbName(),
					DbConnection.getDb().getUserName(), DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			stmt.execute(pQuery);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false; // creazione db non andata abuon fine
		} finally {
			// Finally è sempre eseguito quindi è SICURO (safe) che connessione statement
			// vengono chiusi (close).
			// Chiusura statement e connessione (ordine di apertura)
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

	/*
	 * metodo da richiamare per INSERT, UPDATE, DELETE
	 * 
	 * @param pQuery (INSERT INTO / UPDATE / DELETE)
	 * 
	 * @return >0 numero di record su cui sono state eseguite le operazioni , -1 SQL
	 * non anadata a buon fine, * 0 nessun record inserito/aggiornato/eliminato
	 */
	public static int executeUpdate(String pQuery) {
		int result = -1;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			result = stmt.executeUpdate(pQuery);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}

	/*
	 * Codice di esempio per eseguire SQL di tipo SELECT
	 * @param pQUery string sql con query
	 */
	public static void executeQuery_esempio(String pQuery) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;
		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUserName(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(pQuery);
			while (rows.next()) {
				// legge tutte le righe/records contenute in rows
				// fino a rows.next = false;
				// ovvero raggiunto EOF (End Of File)
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