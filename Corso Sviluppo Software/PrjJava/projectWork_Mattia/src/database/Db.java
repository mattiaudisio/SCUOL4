package database;

import dbMysql.DbConnection;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;

public class Db {

	private static String nomeDb="simulazioneesame";
	
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
	
	public static void executeQuery(String pQuery,ISelectPassResultSet pObject) {
		DbConnection.getDb().setNomeDb(nomeDb);
		QueryDbExecute.executeQuery(pQuery, pObject);
	}
}
