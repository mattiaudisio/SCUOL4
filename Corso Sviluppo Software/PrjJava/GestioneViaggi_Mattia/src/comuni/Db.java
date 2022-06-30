package comuni;

import dbMysql.DbConnection;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;

public class Db {

	private static String nomeDB = "gestioneviaggi_mattia";

	public static DbConnection getDb() {
		DbConnection.getDb().setNomeDb(nomeDB);
		return DbConnection.getDb();
	}

	public static boolean execute(String pQuery) {
		DbConnection.getDb().setNomeDb(nomeDB);
		return QueryDbExecute.execute(pQuery);
	}

	public static void executeQuery(String pQuery, ISelectPassResultSet pSelect) {
		DbConnection.getDb().setNomeDb(nomeDB);
		QueryDbExecute.executeQuery(pQuery, pSelect);
	}

	public static int executeUpdate(String pQuery) {
		DbConnection.getDb().setNomeDb(nomeDB);
		return QueryDbExecute.executeUpdate(pQuery);
	}

}
