package classeMotorino;

import dbMysql.*;

public class CreateDatabase_Veicoli {

	public static void buildTable() {
		/*
		 * MotoID Marca Modello Colore VelocitàMassima Targa
		 */
		String query = "CREATE TABLE IF NOT EXISTS moto (motoId int unsigned NOT NULL AUTO_INCREMENT,"
				+ "marca varchar(45) NOT NULL,modello varchar(45) NOT NULL,colore varchar(35) NOT NULL,"
				+ "velocitaMax double,targa varchar(15),PRIMARY KEY (motoId))";
		// ** Richiama metodo e verifica esito
		if (QueryDbExecute.execute(query)) {
			System.out.println("query eseguita");
		} else {
			System.out.println("query non eseguita");
		}
	}

	public static void buildDatabase() {
		// ** prendo il nome del database che è stato impostato in precedenza
		String nomeDb = DbConnection.getDb().getNomeDb();
		// ** query creazione DB
		String query = "CREATE DATABASE IF NOT EXISTS " + nomeDb;
		// ** Richiama metodo e verifica esito
		if (QueryDbExecute.CreazioneDatabase(query)) {
			System.out.println("database creato " + nomeDb);
		} else {
			System.out.println("Errore creazione database " + nomeDb);
		}
	}

	public static void truncateTable() {
		String query = "TRUNCATE moto;";
		if (QueryDbExecute.executeUpdate(query) >= 0) {
			System.out.println("Tabella pulita");
		} else {
			System.out.println("Errore TRUNCATE ");
		}

	}
}
