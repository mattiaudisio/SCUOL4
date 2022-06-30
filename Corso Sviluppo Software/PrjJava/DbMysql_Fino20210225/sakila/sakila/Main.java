package sakila;

import dbMysql.DbConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection.getDb().setNomeDb("sakila");
		// SakilaSelect.SelectAll();
		System.out.println("** RECORD SCELTO **");
		SakilaSelect.selectById(34);
		System.out.println("\n** ELENCO DI RECORD TRA DUE VALORI **");
		SakilaSelect.selectIntervalloID(6, 38);
	}

}
