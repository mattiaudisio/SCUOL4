package dbMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * classe non ereditabile (final), quindi di questa classe non è ereditabile un oggetto
 * (quindi il costruttore è privato!)
 */

public final class QueryDbExecute {

	/*
	 * essendo privato non è possibile costruire un oggetto in quanto contiene SOLO
	 * metodi metodi statici!
	 */

	private QueryDbExecute() {
	}

	/*
	 * CrezioneDatabase è da utilizzare SOLO per creare un nuovo Db
	 * 
	 * @parametro pQUery conterrà "CREATE Db"
	 * 
	 * @return torna true se Db è creato con successo
	 */
	public static boolean CreazioneDatabase(String pQuery) {

		// devono essere dichiarati al di fuori del try in quanto
		// utilizzate anche nel blocco finally
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriverWithoutDbName(),
					DbConnection.getDb().getUsername(), DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			stmt.execute(pQuery);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			// finally è sempre eseguito quindi è SICURO (safe) che connessione statement
			// vengano chiusi (close)
			// chiusura statement e connessione
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

	/*
	 * metodo da richiamare per eseguire INSERT INTO / UPDATE / DELETE mi ritorna un
	 * int maggiore di 0 con il numero di record nel quale sono state eseguite le
	 * operazioni 0 se nessun record inserito/aggiornato/eliminato -1 SQL non andata
	 * a buon fine
	 */

	public static int executeUpdate(String pQuery) {
		Connection conn = null;
		Statement stmt = null;
		int result = -1;

		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			result = stmt.executeUpdate(pQuery);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		} finally {
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

	/*
	 * codice di esempio per eseguire SQL di tipo SELECT
	 * 
	 * @param pQuery sarà string SQL con SELECT
	 */

//	public static void executeQuery(String pQuery) {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rows = null;
//
//		try {
//			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
//					DbConnection.getDb().getPassword());
//			stmt = conn.createStatement();
//			rows = stmt.executeQuery(pQuery);
//			// lettura di tutte le righe
//			while (rows.next()) {
//				// legge tutti i record contenuti in rows fino a
//				// rows.next=false, ovvero raggiunto EOF, End Of File
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			// return result;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			// return result;
//		} finally {
//			/* 3 */try {
//				if (rows != null)
//					rows.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			/* 2 */try {
//				if (stmt != null)
//					stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			/* 1 */try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}

	/**
	 * metodo da richiamare per CREATE TABLE, ALTER, DROP, TRUNCATE etc return true
	 * se l'esecuzione SQL + andata a buon fine
	 * 
	 * @param pQuery
	 * @return
	 */
	public static boolean execute(String pQuery) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			stmt.execute(pQuery);
			return true;
		}
		/*
		 * Intercetta SOLO errori generati da java.sql
		 */
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		/*
		 * intercetta tutti gli altri errori in quanto utilizza la classe base
		 * "exception"
		 */
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
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

	
	public static void executeQuery(String pQuery,ISelectPassResultSet pSelect) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rows = null;

		try {
			conn = DriverManager.getConnection(DbConnection.getDb().getDriver(), DbConnection.getDb().getUsername(),
					DbConnection.getDb().getPassword());
			stmt = conn.createStatement();
			rows = stmt.executeQuery(pQuery);
			
			//** richiama metodo implementato nell'interfaccia
			pSelect.passResultset(rows);
			// lettura di tutte le righe
//			while (rows.next()) {
//				// legge tutti i record contenuti in rows fino a
//				// rows.next=false, ovvero raggiunto EOF, End Of File
//
//			}
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

}
