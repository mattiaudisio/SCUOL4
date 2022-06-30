/**
 * 1) creare (se non già esistente) nell'applicazione un package db
 * 2) copiare nel package db questa classe
 * 3) assegnare a stringa nomeb il nome del dp da utilizzare
 * 4) rendere class db pubblica : public class Db
 */
package _ImportareInApp;

import dbMysql.DbConnection;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;

class Db { // rendere pubblica --> public class Db 

	private static String nomeDb="..... nome del databse da utilizzare";
	
	public static DbConnection getDb() {
		DbConnection.getDb().setNomeDb(nomeDb);
		return DbConnection.getDb();
	}
	
	public static boolean execute(String pQuery) {
		DbConnection.getDb().setNomeDb(nomeDb);
		return QueryDbExecute.execute(pQuery);
	}
	
	public static int executeUpdate(String pQuery) {
		DbConnection.getDb().setNomeDb(nomeDb);
		return QueryDbExecute.executeUpdate(pQuery);
	}
	
	public static void executeQuery(String pQuery,ISelectPassResultSet pSelect) {
		DbConnection.getDb().setNomeDb(nomeDb);
		QueryDbExecute.executeQuery(pQuery, pSelect);
	}
}
