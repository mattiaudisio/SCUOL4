package dbMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** public final class QueryDbExecute
 * 
 * - Classe non ereditabile  (final)
 * - di questa classe non è possibile creare un oggetto (costruttore privato)
 * - contiene solo metodi statici
 * 
 * static boolean CreateDatabaseByName(String pDbName) - crea db se non esiste
 * static boolean execute(String pQuery) - per CREATE TABLE, ALTER, DROP, TRUNCATE ecc.
 * static int executeUpdate(String pQuery) - per INSERT INTO / UPDATE / DELETE
 * 		 	 @return 	>0 numero di record su cui sono state eseguite le operazioni
 * 			 0 nessun record inserito/aggiornato/eliminato
 * 			-1 SQL non andata a buon fine
 * static void executeQuery(String pQuery, ISelectPassResultSet pObject) per SELECT
 */



public final class QueryDbExecute {
	/**
	 * essendo privato non è pox cotruire l'oggetto
	 */
	private QueryDbExecute() {}
	
	/**
	 * Questo metodo è da utilizzare SOLO per creare un 
	 * nuovo db
	 * @param pDbName nome del databse da creare
	 * @return True se db creato con successo
	 */
	public static boolean CreateDatabaseByName(String pDbName) {
		// devono essere dichiarati al di fuori del Try in quanto
		// utilizzate anche nel blocco finally
		Connection conn=null;
		Statement stmt = null;
		String query = "CREATE DB IF NOT EXISTS " + pDbName+";";
		try {
			
			/*1  connessione */
			conn = DriverManager.getConnection(DbConnection.getDb()
						.getDriverWithoutDbName()
						,DbConnection.getDb().getUserName()
						,DbConnection.getDb().getPassword());
			
			/*2  Statement */
			stmt = conn.createStatement();
			/*3  essecuzione query */
			stmt.execute(query);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false; // creazione db non andata a buon fine
		}
		finally {
			// Finally è sempre eseguito quindi è SICURO (safe) che
			// connessione statement vengono chiusi (close).
			
			/*4 Chiusura statement e connessione  (ordine inverso rispetto a creazione)*/
			/*2*/ try {if (stmt!=null) stmt.close();} catch (SQLException e) {e.printStackTrace();}
			/*1*/ try {if (conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	/**
	 * metodo da richiamare per CREATE TABLE, ALTER, DROP, TRUNCATE ecc.
	 * @param pQuery
	 * @return True se esecuzione sql andata a buon fine
	 */
	public static boolean execute(String pQuery) {
		
		Connection conn=null;
		Statement stmt = null;
		try {
			
			/*1  connessione */
			conn = DriverManager.getConnection(DbConnection.getDb()
						.getDriver()
						,DbConnection.getDb().getUserName()
						,DbConnection.getDb().getPassword());
			
			/*2  Statement */
			stmt = conn.createStatement();
			/*3  essecuzione query */
			stmt.execute(pQuery);
			return true;
			
		} 
		//** intercetta SOLO errori generati da java.sql
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		//** intercetta tutti gli altri errori in quanto utilizza 
		//** la classe base Exception
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			/*4 Chiusura connessione*/
			/*2*/ try {if (stmt!=null) stmt.close();} catch (SQLException e) {e.printStackTrace();}
			/*1*/ try {if (conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}

		}
	}
	
	/**
	 * Metodo da richiamare per eseguire INSERT INTO / UPDATE / DELETE 
	 * @param pQuery (INSERT INTO / UPDATE / DELETE)
	 * @return 	>0 numero di record su cui sono state eseguite le operazioni
	 * 			 0 nessun record inserito/aggiornato/eliminato
	 * 			-1 SQL non andata a buon fine
	 */
	public static int executeUpdate(String pQuery) {
		Connection conn=null;
		Statement stmt = null;
		int result = -1;
		try {
			/*1  connessione */
			conn = DriverManager.getConnection(DbConnection.getDb()
						.getDriver()
						,DbConnection.getDb().getUserName()
						,DbConnection.getDb().getPassword());
			
			/*2  Statement */
			stmt = conn.createStatement();
			/*3  essecuzione query */
			result = stmt.executeUpdate(pQuery);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		finally {
			/*4 Chiusura connessione*/
			/*2*/ try {if (stmt!=null) stmt.close();} catch (SQLException e) {e.printStackTrace();}
			/*1*/ try {if (conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}

		}
	}

	
	public static void executeQuery(String pQuery, ISelectPassResultSet pObject) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rows = null;
		//** pObject non può essere null
		//** può essere istanza di una classe Jframe, jDialog ecc. o una di classe qualunque
		if (pObject == null) return;
		try {
			/*1  connessione */
			conn = DriverManager.getConnection(DbConnection.getDb()
						.getDriver()
						,DbConnection.getDb().getUserName()
						,DbConnection.getDb().getPassword());
			
			/*2  Statement */
			stmt = conn.createStatement();
			/*3  essecuzione query */
			//-- di questi 3 metodi ci interessano per ora solo quelli con un parametro
			//-- di tipo stringa
			// Execute("istr.SQL") --> CREATE DB/TB ALTER DROP --> amministrazioe DB
			// ExecuteUpdate ("istr.SQL") --> INSERT/UPDATE/DELETE (relativo a tabella) --> torna numero record modificati
			// ExecuteQuery ("istr.SQL") --> SELECT --> torna ResultSet
			rows = stmt.executeQuery(pQuery);
			
			//** richiama metodo implemetato nell'interfaccia e passa come parametro
			//** il risultato della query che può o meno contenere delle righe
			pObject.passResultSet(rows);
			
			/*3bis*/ // lettura di tutte le righe/records di rows
			// se non trovato nessun record ciclo while mai eseguito
//			while (rows.next()) {
//				// legge tutte le righe/records contenuti in rows
//				// fino a rows.next = false;
//				// ovvero raggiunto EOF (End Of File)
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//return result;
		}
		finally {
			/*4 Chiusura connessione*/
			/*3*/ try {if (rows!=null) rows.close();} catch (SQLException e) {e.printStackTrace();}
			/*2*/ try {if (stmt!=null) stmt.close();} catch (SQLException e) {e.printStackTrace();}
			/*1*/ try {if (conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
